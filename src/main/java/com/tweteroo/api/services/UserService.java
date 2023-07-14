package com.tweteroo.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.models.Users;
import com.tweteroo.api.repository.UsersRepository;

@Service
public class UserService {
    
    @Autowired
    private UsersRepository usersRepository;

    public List<Users> findAllUsers() {
        return usersRepository.findAll();
    }

    public String createUser(UserDTO req) {
        ArrayList<String> usernamesList = usersRepository.findAllUsernames();
        
        if(usernamesList.contains(req.username())) {
            return "Usuário já cadastrado!";
        }

        usersRepository.save(new Users(req));

        return "OK!";
    }

}
