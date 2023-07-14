package com.tweteroo.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.models.Tweets;
import com.tweteroo.api.models.Users;
import com.tweteroo.api.repository.TweetRepository;
import com.tweteroo.api.repository.UsersRepository;

@Service
public class TweetService {

    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private UsersRepository usersRepository;

    public List<Tweets> getTweetsPerPage(int page) {
        List<Tweets> tweetsListPerPage = new ArrayList<>();
        List<Tweets> tweetsList = tweetRepository.findAll();

        if(page * 5 - 5 > tweetsList.size()) {
            return tweetsListPerPage;
        }

        for(int i = page * 5 - 5; i < page * 5; i++) {
            if(i == tweetsList.size()) {
                break;
            }

            tweetsListPerPage.add(tweetsList.get(i));
        }

        return tweetsListPerPage;
    }

    public List<Tweets> getTweetsByUsername(String username) {
        return tweetRepository.findTweetsByUsername(username);
    }

    public void createTweet(TweetDTO tweet) {
        List<Users> usersList = usersRepository.findAll();

        for(int i = 0; i < usersList.size(); i++) {
            if(usersList.get(i).getUsername().equals(tweet.username())) {
                tweetRepository.save(new Tweets(tweet, usersList.get(i).getAvatar()));

                break;
            }
        }
    }
}
