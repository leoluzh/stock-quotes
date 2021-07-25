package com.lamdbasys.stockquotesapi.controller;

import com.lamdbasys.stockquotesapi.dto.QuoteDto;
import com.lamdbasys.stockquotesapi.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController()
@RequestMapping("/api/v1/quotes")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class QuoteController implements Serializable {

    private final QuoteService service;

    @GetMapping("/{symbol}")
    public Page<QuoteDto> findAllBySymbol(
            @PathVariable("symbol") String symbol,
            @PageableDefault() Pageable pageable){
        return service.findAllBySymbol(symbol,pageable);
    }

}
