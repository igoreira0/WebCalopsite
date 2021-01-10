package com.calopsite.demo.services;
import com.calopsite.demo.domain.entities.Mutation;
import com.calopsite.demo.repositories.MutationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class NameMutations {
    @Autowired
    private MutationRepository mutRepository;

    @GetMapping
    public List<Mutation> findAll(){
        return mutRepository.findAll();
    }
    @GetMapping
    public Mutation findByID(long id){
        Optional<Mutation> mutation = mutRepository.findById(id);
        return mutation.get();
    }



}
