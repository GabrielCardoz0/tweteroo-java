package com.tweteroo.api.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tweteroo.api.models.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query(value = "SELECT username FROM users", nativeQuery = true)
    ArrayList<String> findAllUsernames();
}
