package com.calopsite.demo.resources;

import com.calopsite.demo.domain.entities.User;
import com.calopsite.demo.services.UserService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @DeleteMapping("/del")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<String> delUser(@RequestParam("email") @NotNull String email){
        userService.delEmail(userService.getUserIdIfExist(email));
        return ResponseEntity.ok().body("Deleted");
    }

    @PostMapping("/new")
    public ResponseEntity<User> newUser(@RequestParam("name") @NotNull String name,
                        @RequestParam("email") @NotNull String email,
                        @RequestParam("password") @NotNull String password){
        User u1 = userService.createNewUser(name,email,password);
        return ResponseEntity.ok().body(u1);
    }



}
