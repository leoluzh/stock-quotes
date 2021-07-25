package com.lamdbasys.stockquotesapi.repository;

import com.lamdbasys.stockquotesapi.entity.Quote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuoteRepository extends PagingAndSortingRepository<Quote,Integer> {

    @RestResource(rel = "quotes-by-symbol" , path = "quotes-by-symbol")
    Page<Quote> findAllBySymbol(@Param("symbol") String symbol, Pageable pageable);

    Optional<Quote> findFirstBySymbolOrderByTimestampDesc(String test);
}
