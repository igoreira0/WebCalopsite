package com.calopsite.demo.repositories;

import com.calopsite.demo.domain.entities.Bird;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirdRepository extends JpaRepository<Bird, Long> {
}
