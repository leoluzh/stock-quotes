package com.lamdbasys.stockquotesapi.mappers;

import com.lamdbasys.stockquotesapi.dto.QuoteDto;
import com.lamdbasys.stockquotesapi.entity.Quote;
import org.mapstruct.Mapper;

//@Mapper(componentModel = "spring")
@Mapper(componentModel = "spring")
public interface QuoteMapper {

    Quote toEntity(final QuoteDto quoteDto);

    QuoteDto toDto(final Quote quote);

}
