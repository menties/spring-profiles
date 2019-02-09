package com.epam.springprofiles.service;

import com.epam.springprofiles.model.User;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface UserService {

    void save(User user);
    void save(Collection<User> users);

}
