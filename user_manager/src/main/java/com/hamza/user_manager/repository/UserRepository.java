package com.hamza.user_manager.repository;

import com.hamza.user_manager.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO user (first_name, last_name, email, password) VALUES (:first_name, :last_name, :email, :password)", nativeQuery = true)
    int registerNewUser(@Param("first_name") String first_name, @Param("last_name") String last, @Param("email") String email, @Param("password") String password);
    @Query(value = "SELECT email FROM user WHERE email = :email", nativeQuery = true)
    String checkUserEmail(@Param("email") String email);

    @Query(value = "SELECT password FROM user WHERE email = :email", nativeQuery = true)
    String checkUserPasswordByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM user WHERE email = :email", nativeQuery = true)
    User getUserDetailsByEmail(@Param("email") String email);
}
