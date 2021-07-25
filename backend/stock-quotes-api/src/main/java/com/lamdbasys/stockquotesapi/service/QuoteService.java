package com.lamdbasys.stockquotesapi.service;

import com.lamdbasys.stockquotesapi.dto.QuoteDto;
import com.lamdbasys.stockquotesapi.mappers.QuoteMapper;
import com.lamdbasys.stockquotesapi.repository.QuoteRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class QuoteService implements Serializable {

    private final QuoteRepository repository;
    private final QuoteMapper quoteMapper;

    public Page<QuoteDto> findAllBySymbol(String symbol, Pageable pageable){
        return this.repository
                .findAllBySymbol(symbol,pageable)
                .map(quoteMapper::toDto);
    }

}
