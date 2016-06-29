package com.spring.mvc.repository;

import com.spring.mvc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * @Query annotation helps you to give a method parameter
     * a concrete name and bind the name to the query.
     */
    @Query("SELECT u FROM User u WHERE u.lastName = :lastName")
    User findByLastName(@Param("lastName") String lastName);
}
