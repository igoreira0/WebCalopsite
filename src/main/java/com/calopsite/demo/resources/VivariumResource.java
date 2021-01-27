package com.calopsite.demo.resources;

import com.calopsite.demo.domain.entities.Vivarium;
import com.calopsite.demo.services.VivariumService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/new")
    public void seedVivarium(@RequestParam("description") @NotNull String description) {
        vivariumService.newVivarium(description);
    }

}
