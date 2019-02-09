package com.epam.springprofiles.service.impl;

import com.epam.springprofiles.model.User;
import com.epam.springprofiles.repository.UserRepository;
import com.epam.springprofiles.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DefaultUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void save(Collection<User> users) {
        userRepository.saveAll(users);
    }
}
