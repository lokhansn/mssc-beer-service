package com.sgl.msscbeerservice.services.brewing;

import com.sgl.common.events.BrewBeerEvent;
import com.sgl.msscbeerservice.config.JmsConfig;
import com.sgl.msscbeerservice.domain.Beer;
import com.sgl.msscbeerservice.repositories.BeerRepository;
import com.sgl.msscbeerservice.services.inventory.BeerInventoryService;
import com.sgl.msscbeerservice.web.mappers.BeerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrewingService {

    private final BeerRepository beerRepository;
    private final BeerInventoryService beerInventoryService;
    private final JmsTemplate jmsTemplate;
    private final BeerMapper beerMapper;

    // Keeping it at 10 sec, otherwise there would be too many message will flow
    @Scheduled(fixedRate = 10000)
    public void checkForLowInventory(){
        List<Beer> beers = beerRepository.findAll();

        beers.forEach(beer ->{
            Integer invQOH = beerInventoryService.getOnhandInventory(beer.getId());

            log.debug("Min Onhand is: "+ beer.getMinOnHand());
            log.debug("Inventory is: "+ invQOH);

            if(beer.getMinOnHand() >= invQOH){
                jmsTemplate.convertAndSend(JmsConfig.BREWING_REQUEST_QUEUE, new BrewBeerEvent(beerMapper.beerToBeerDto(beer)));
            }
        });
    }
}
