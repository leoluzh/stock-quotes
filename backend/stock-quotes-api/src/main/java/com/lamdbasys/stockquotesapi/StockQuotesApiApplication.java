package com.lamdbasys.stockquotesapi;

import com.lamdbasys.stockquotesapi.entity.Quote;
import com.lamdbasys.stockquotesapi.repository.QuoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.RandomDataImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

@EnableScheduling
@SpringBootApplication
@Slf4j
public class StockQuotesApiApplication {

    @Autowired
    private QuoteRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(StockQuotesApiApplication.class, args);
    }


    @Scheduled(fixedDelay = 1000)
    public void generateData() {
        log.info(
                this.repository.findFirstBySymbolOrderByTimestampDesc("TEST")
                        .map(this::generateNewData)
                        .orElseGet(this::initializeData).toString());
    }

    public Quote initializeData() {
        var quote = Quote.builder()
                .symbol("TEST")
                .openValue(new BigDecimal("0.222222"))
                .closeValue(new BigDecimal("0.222222"))
                .timestamp(new Date())
                .build();
        return this.repository.save(quote);
    }

    public Quote generateNewData(final Quote quote) {
        return Quote.builder()
                .symbol(quote.getSymbol())
                .openValue(quote.getOpenValue().multiply(gerenetareRandom()))
                .closeValue(quote.getCloseValue().multiply(gerenetareRandom()))
                .timestamp(new Date())
                .build();
    }

    public BigDecimal gerenetareRandom(){
        return new BigDecimal(new RandomDataGenerator().nextUniform(-0.10,0.10));
    }


}
