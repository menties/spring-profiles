package com.epam.springprofiles.service;

import com.epam.springprofiles.model.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    void save(Address address);

    void save(List<Address> addresses);
}
