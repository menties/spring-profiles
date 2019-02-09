package com.epam.springprofiles;

import com.epam.springprofiles.model.Address;
import com.epam.springprofiles.model.User;
import com.epam.springprofiles.parser.CSVFileParser;
import com.epam.springprofiles.service.AddressService;
import com.epam.springprofiles.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.List;

import static com.epam.springprofiles.constants.DataFiles.ADDRESSES;
import static com.epam.springprofiles.constants.DataFiles.USERS;

@SpringBootApplication
public class SpringProfilesApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private CSVFileParser parser;

    public static void main(String[] args) {
        SpringApplication.run(SpringProfilesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<User> users = parser.parseUsersFile(USERS);
        List<Address> addresses = parser.parserAddressesFile(ADDRESSES);

        addressService.save(addresses);

        User user = users.get(0);
        user.setAddresses(new HashSet<>(addresses));

        userService.save(users);
    }
}

