package com.calopsite.demo.resources;
import com.calopsite.demo.domain.entities.Mutation;
import com.calopsite.demo.services.MutationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/mutations")
public class MutationResource {
    @Autowired
    private MutationsService mutationsService;

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
}
