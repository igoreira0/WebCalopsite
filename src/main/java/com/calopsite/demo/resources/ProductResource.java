package com.calopsite.demo.resources;

import com.calopsite.demo.domain.entities.Bird;
import com.calopsite.demo.domain.entities.Product;
import com.calopsite.demo.domain.entities.User;
import com.calopsite.demo.domain.enums.ProductType;
import com.calopsite.demo.dto.UserDTO;
import com.calopsite.demo.repositories.ProductRepository;
import com.calopsite.demo.services.BirdService;
import com.calopsite.demo.services.UserService;
import com.calopsite.demo.utils.exceptions.ProductTypeException;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;


@RestController
@RequestMapping(value = "/products")
public class ProductResource {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserService userService;

    @PostMapping("/new")
    public void seedVivarium(@RequestParam("name") @NotNull String productName,
                             @RequestParam("type") @NotNull int  type,
                             @RequestParam("price") @NotNull Float  productPrice,
                             @RequestParam("quantity") @NotNull Float productQuantity) {
        if (type == 0) {
            Product product = new Product(null, productName, productQuantity, userService.getLoggedUser().getId(), ProductType.FOOD,productPrice);
            productRepository.save(product);
        }else if(type == 1){
            Product product = new Product(null, productName, productQuantity, userService.getLoggedUser().getId(), ProductType.MEDICAMENT,productPrice);
            productRepository.save(product);
        }else{
            throw new ProductTypeException(HttpStatus.NOT_FOUND,type + " não existe");
        }
    }

}
