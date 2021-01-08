package com.calopsite.demo.services;

import com.calopsite.demo.entities.User;
import com.calopsite.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }
    @GetMapping
    public User findByID(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }
}
