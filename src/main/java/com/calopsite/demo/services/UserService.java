package com.calopsite.demo.services;

import com.calopsite.demo.domain.entities.User;
import com.calopsite.demo.repositories.UserRepository;
import com.calopsite.demo.utils.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
    @GetMapping
    public User findByID(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
            throw new NotFoundException(HttpStatus.BAD_REQUEST,"O usuário não existe!");
        return user.get();
    }
}
