package com.lamdbasys.stockquotesapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuoteDto implements Serializable {

    private Long id;
    private String symbol;
    private BigDecimal openValue;
    private BigDecimal closeValue;
    private Date timestamp;

}
