package com.jpms.codinggame.repository;

import com.jpms.codinggame.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);


    Optional<User> findByUserName(String username);

    List<User> findTop50ByOrderByScoreDesc();

    @Query("UPDATE User u SET u.isDone = true")
    void updateAllState();
}
