package com.epam.springprofiles.repository;

import com.epam.springprofiles.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
