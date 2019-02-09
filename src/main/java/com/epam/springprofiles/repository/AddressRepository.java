package com.epam.springprofiles.repository;

import com.epam.springprofiles.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
