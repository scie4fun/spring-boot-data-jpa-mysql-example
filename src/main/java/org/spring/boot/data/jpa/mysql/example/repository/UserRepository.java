package org.spring.boot.data.jpa.mysql.example.repository;

import org.spring.boot.data.jpa.mysql.example.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
