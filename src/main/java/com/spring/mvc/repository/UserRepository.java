package com.spring.mvc.repository;

import com.spring.mvc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    /*@Query("select u from User u where u.username = :username")
    User findByUserName(@Param("username") String userName);*/
}
