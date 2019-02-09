package com.epam.springprofiles.service.impl;

import com.epam.springprofiles.model.Address;
import com.epam.springprofiles.repository.AddressRepository;
import com.epam.springprofiles.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultAddressService implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void save(Address address) {
        addressRepository.save(address);
    }

    @Override
    public void save(List<Address> addresses) {
        addressRepository.saveAll(addresses);
    }
}
