package com.calopsite.demo.resources;
import com.calopsite.demo.domain.entities.Bird;
import com.calopsite.demo.domain.entities.User;
import com.calopsite.demo.services.BirdService;
import com.calopsite.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping(value = "/birds")
public class BirdResource {
    @Autowired
    private BirdService birdService;

    @GetMapping
    public ResponseEntity<List<Bird>> findAll(){
        List<Bird> list = birdService.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Bird> findByID(@PathVariable Long id){
        Bird bird = birdService.findByID(id);
        return ResponseEntity.ok().body(bird);
    }

}
