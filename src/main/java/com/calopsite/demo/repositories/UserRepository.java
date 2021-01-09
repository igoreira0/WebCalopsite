package com.calopsite.demo.repositories;

import com.calopsite.demo.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
