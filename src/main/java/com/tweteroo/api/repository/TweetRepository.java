package com.tweteroo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tweteroo.api.models.Tweets;
import java.util.List;

public interface TweetRepository extends JpaRepository<Tweets, Long> {
    @Query(value = "SELECT * FROM tweets WHERE username = ?1", nativeQuery = true)
    List<Tweets> findTweetsByUsername(String username);

}
