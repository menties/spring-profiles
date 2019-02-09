package com.epam.springprofiles.repository.mongo;

import com.epam.springprofiles.model.Address;
import com.epam.springprofiles.repository.AddressRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import static com.epam.springprofiles.constants.Profiles.MONGO;

@Repository
@Profile(MONGO)
public interface MongoAddressRepository extends AddressRepository, MongoRepository<Address, Long> {
}
