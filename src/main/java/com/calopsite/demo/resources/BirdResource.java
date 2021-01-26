package com.calopsite.demo.resources;

import com.calopsite.demo.domain.entities.Bird;
import com.calopsite.demo.domain.entities.Mutation;
import com.calopsite.demo.domain.entities.User;
import com.calopsite.demo.domain.entities.Vivarium;
import com.calopsite.demo.dto.UserDTO;
import com.calopsite.demo.repositories.BirdRepository;
import com.calopsite.demo.services.BirdService;
import com.calopsite.demo.services.UserService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/birds")
public class BirdResource {
    @Autowired
    private BirdService birdService;
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Bird>> findAll() {
        List<Bird> list = birdService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Bird> findByID(@PathVariable Long id) {
        Bird bird = birdService.findByID(id);
        return ResponseEntity.ok().body(bird);
    }


    @PostMapping(value ="/new")
    public void newBird(
            @RequestParam("mutation") @NotNull Long mutation,
            @RequestParam("fatherId") Long fatherId,
            @RequestParam("motherId") Long motherId,
            @RequestParam("vivarium") Long vivarium){
        UserDTO userDTO = userService.getLoggedUser();


        birdService.newBird(mutation, fatherId, motherId,vivarium, userDTO.getId());


    }
}
