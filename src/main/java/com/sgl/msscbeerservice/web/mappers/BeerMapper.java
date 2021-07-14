package com.sgl.msscbeerservice.web.mappers;

import com.sgl.msscbeerservice.domain.Beer;
import com.sgl.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);
}
