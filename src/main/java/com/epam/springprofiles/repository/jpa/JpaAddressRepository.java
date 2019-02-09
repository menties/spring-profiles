package com.epam.springprofiles.repository.jpa;

import com.epam.springprofiles.model.Address;
import com.epam.springprofiles.repository.AddressRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import static com.epam.springprofiles.constants.Profiles.JPA;

@Repository
@Profile(JPA)
public interface JpaAddressRepository extends AddressRepository, JpaRepository<Address, Long> {
}
