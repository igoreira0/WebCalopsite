package com.calopsite.demo.resources;

import com.calopsite.demo.domain.entities.User;
import com.calopsite.demo.services.UserService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findByID(@PathVariable Long id){
        User obj = userService.findByID(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping("/new/{name}/{email}")
    public void newUser(@PathVariable("name") @NotNull String name,
                        @PathVariable("email") @NotNull String email,
                        @RequestParam("password") @NotNull String password){
        userService.createNewUser(name,email,password);
    }

}
