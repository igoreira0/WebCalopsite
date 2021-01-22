package com.calopsite.demo.services;

import com.calopsite.demo.domain.entities.Product;
import com.calopsite.demo.domain.entities.User;
import com.calopsite.demo.domain.enums.Profile;
import com.calopsite.demo.repositories.UserRepository;
import com.calopsite.demo.security.UserSS;
import com.calopsite.demo.utils.exceptions.AuthorizationException;
import com.calopsite.demo.utils.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> findAll(){
        return userRepository.findAll();
    }
    @GetMapping
    public User findByID(Long id){
        UserSS userSS = authenticated();
        if(userSS == null || !userSS.hasRole(Profile.ADMIN) && id != userSS.getId()){
            throw new AuthorizationException(HttpStatus.FORBIDDEN,"Acesso negado");
        }
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
            throw new NotFoundException(HttpStatus.BAD_REQUEST,"O usuário não existe!");
        return user.get();
    }

    public void createNewUser(String name, String email, String password){
        User u1 = new User(null, name, email, bCryptPasswordEncoder.encode(password), com.calopsite.demo.domain.enums.Profile.CLIENT);
        userRepository.save(u1);
    }
    public void delEmail(Long id){
        userRepository.deleteById(id);
    }

    public Long getUserIdIfExist(String email){
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email));
        if(user.isEmpty())
            throw new NotFoundException(HttpStatus.BAD_REQUEST,"Usuário não cadastrado");
        return user.get().getId();
    }

    public static UserSS authenticated(){
        try{
            return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }catch(Exception e){
            return null;
        }

    }



}
