package com.calopsite.demo.services;
import com.calopsite.demo.domain.entities.Bird;
import com.calopsite.demo.domain.entities.Mutation;
import com.calopsite.demo.repositories.BirdRepository;
import com.calopsite.demo.repositories.MutationRepository;
import com.calopsite.demo.utils.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;
import java.util.Optional;
@Service
public class BirdService {
    @Autowired
    private BirdRepository birdRepository;

    @GetMapping
    public List<Bird> findAll(){
        return birdRepository.findAll();
    }
    @GetMapping
    public Bird findByID(long id){
        Optional<Bird> bird = birdRepository.findById(id);
        if(bird.isEmpty())
            throw new NotFoundException(HttpStatus.BAD_REQUEST,"A Mutação não existe!");
        return bird.get();
    }
}
