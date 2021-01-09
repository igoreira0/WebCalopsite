package com.calopsite.demo.repositories;

import com.calopsite.demo.domain.entities.Mutation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MutationRepository extends JpaRepository<Mutation, Long> {
}
