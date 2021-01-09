package com.calopsite.demo.services;

import com.calopsite.demo.domain.entities.HistSeed;
import com.calopsite.demo.repositories.HistSeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistSeedService {

    @Autowired
    private VivariumService vivariumService;

    @Autowired
    private ProductService productService;

    @Autowired
    private HistSeedRepository histSeedRepository;

    public void seedVivarium(Long productId, Long vivariumId,  Float quantity){
        productService.checkProductQuantity(productId, quantity);
        vivariumService.getVivariumIfExist(vivariumId);
        HistSeed histSeed = new HistSeed(null, productId, vivariumId, quantity);
        productService.updateQuantity(productId, quantity);
        histSeedRepository.save(histSeed);
    }
}
