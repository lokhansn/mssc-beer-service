package com.sgl.common.events;

import com.sgl.common.events.BeerEvent;
import com.sgl.msscbeerservice.web.model.BeerDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BrewBeerEvent extends BeerEvent {
    public BrewBeerEvent(BeerDto beerDto){
        super(beerDto);
    }
}
