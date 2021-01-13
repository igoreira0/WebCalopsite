package com.calopsite.demo.resources;

import com.calopsite.demo.domain.entities.Mutation;
import com.calopsite.demo.domain.entities.Vivarium;
import com.calopsite.demo.services.BirdService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/newbird")
public class NewBirdResource {
    @Autowired
    private BirdService birdService;

    @PostMapping("/{id}")
    public void newBird(
            @PathVariable("id") @NotNull Long id,
            @RequestParam("mutation") @NotNull Mutation mutation,
            @RequestParam("fatherId") Long fatherId,
            @RequestParam("motherId") Long motherId,
            @PathVariable("vivarium") Vivarium vivarium) {

    }
}
