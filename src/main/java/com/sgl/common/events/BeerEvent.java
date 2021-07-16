package com.sgl.common.events;

import com.sgl.msscbeerservice.web.model.BeerDto;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerEvent implements Serializable {
    static final long serialVersionUID = -6060896927835774739L;

    private BeerDto beerDto;
}
