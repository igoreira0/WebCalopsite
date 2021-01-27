package com.calopsite.demo.resources;
import com.calopsite.demo.domain.entities.Mutation;
import com.calopsite.demo.dto.UserDTO;
import com.calopsite.demo.services.MutationsService;
import com.calopsite.demo.services.UserService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/mutations")
public class MutationResource {
    @Autowired
    private MutationsService mutationsService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Mutation>> findAll(){
        List<Mutation> list = mutationsService.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Mutation> findByID(@PathVariable Long id){
        Mutation obj = mutationsService.findByID(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping(value = "/user")
    public ResponseEntity<List<Mutation>> findByUser() {
        UserDTO userDTO = userService.getLoggedUser();
        List<Mutation> mutations = mutationsService.findByUser(userService.findByID(userDTO.getId()));
        return ResponseEntity.ok().body(mutations);
    }

    @PostMapping("/new")
    public void newMutation(@RequestParam("description") @NotNull String description,
                            @RequestParam("price") @NotNull float price,
                            @RequestParam("mutation") @NotNull String mutation) {
        mutationsService.newMutation(mutation,price,description);
    }

}
