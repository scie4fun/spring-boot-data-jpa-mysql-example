package org.spring.boot.data.jpa.mysql.example.repository;

import org.spring.boot.data.jpa.mysql.example.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmail(String email);

    @Modifying
    @Query("update User u set u.firstName = ?2, u.lastName = ?3, u.email = ?4 where u.id = ?1")
    void update(Long id, String firstName, String lastName, String email);
}
