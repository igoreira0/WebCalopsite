package com.calopsite.demo.resources;

import com.calopsite.demo.domain.entities.Vivarium;
import com.calopsite.demo.services.VivariumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/vivarium")
public class VivariumResource {

    @Autowired
    private VivariumService vivariumService;

    @GetMapping
    public ResponseEntity<List<Vivarium>> findAll(){
        List<Vivarium> list = vivariumService.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Vivarium> findByID(@PathVariable Long id){
        Vivarium obj = vivariumService.findByID(id);
        return ResponseEntity.ok().body(obj);
    }

}
