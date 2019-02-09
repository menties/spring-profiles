package com.epam.springprofiles.repository.jpa;

import com.epam.springprofiles.model.User;
import com.epam.springprofiles.repository.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import static com.epam.springprofiles.constants.Profiles.JPA;

@Repository
@Profile(JPA)
public interface JpaUserRepository extends UserRepository, JpaRepository<User, Long> {
}
