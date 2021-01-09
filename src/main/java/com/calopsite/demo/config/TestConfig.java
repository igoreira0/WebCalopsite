package com.calopsite.demo.config;

import com.calopsite.demo.domain.entities.*;
import com.calopsite.demo.domain.enums.Gender;
import com.calopsite.demo.domain.enums.ProductType;
import com.calopsite.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private VivariumRepository vivariumRepository;
    @Autowired
    private MutationRepository mutationRepository;
    @Autowired
    private BirdRepository birdRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "123456");
        Long idU1 = userRepository.save(u1).getId();
        Long idU2 = userRepository.save(u2).getId();

        Product p1 = new Product(null, "Alpiste", 3F, idU1, ProductType.FOOD);
        Product p2 = new Product(null, "Xarope", 10F, idU1, ProductType.MEDICAMENT);
        productRepository.saveAll(Arrays.asList(p1,p2));

        Vivarium v1 = new Vivarium(null, 8, "imagine uma descricao", idU1);
        Vivarium v2 = new Vivarium(null, 9, "outra descricao", idU2);
        Vivarium viv1 = vivariumRepository.save(v1);
        Vivarium viv2 = vivariumRepository.save(v2);

        Mutation m1 = new Mutation(null, "Arlequim", 100F);
        Mutation m2 = new Mutation(null, "Fulvo", 90F);
        Mutation m3 = new Mutation(null, "Albino", 500F);
        Mutation mut1 = mutationRepository.save(m1);
        Mutation mut2 = mutationRepository.save(m2);
        Mutation mut3 = mutationRepository.save(m3);

        Bird b1 = new Bird(null, mut1,null, null, viv1, Gender.MALE);
        Bird b2 = new Bird(null, mut2,null, null, viv1, Gender.FEMALE);
        birdRepository.saveAll(Arrays.asList(b1,b2));
        Bird b3 = new Bird(null, mut3, birdRepository.findById(1L).get().getId() , birdRepository.findById(2L).get().getId(), viv2);
        birdRepository.save(b3);



    }
}
