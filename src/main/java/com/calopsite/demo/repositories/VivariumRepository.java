package com.calopsite.demo.repositories;

import com.calopsite.demo.domain.entities.Vivarium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VivariumRepository extends JpaRepository<Vivarium, Long> {
}
