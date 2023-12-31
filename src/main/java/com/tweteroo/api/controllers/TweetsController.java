package com.tweteroo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.models.Tweets;
import com.tweteroo.api.services.TweetService;

@RestController
@RequestMapping("/api/tweets")
public class TweetsController {

    @Autowired
    private TweetService tweetService;

    @GetMapping
    public List<Tweets> getTweets(@RequestParam String page) {
        return tweetService.getTweetsPerPage(Integer.parseInt(page));
    }

    @GetMapping("/{username}")
    public List<Tweets> getTweetsPerUser(@PathVariable String username) {
        return tweetService.getTweetsByUsername(username);
    }

    @PostMapping
    public String postTweet(@RequestBody TweetDTO req) {
        tweetService.createTweet(req);

        return "OK!";
    }

}
