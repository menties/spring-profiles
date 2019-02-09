package com.epam.springprofiles.repository.mongo;

import com.epam.springprofiles.model.User;
import com.epam.springprofiles.repository.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import static com.epam.springprofiles.constants.Profiles.MONGO;

@Repository
@Profile(MONGO)
public interface MongoUserRepository extends UserRepository, MongoRepository<User, Long> {
}
