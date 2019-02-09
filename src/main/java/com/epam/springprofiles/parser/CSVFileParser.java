package com.epam.springprofiles.parser;

import com.epam.springprofiles.model.Address;
import com.epam.springprofiles.model.User;

import java.io.IOException;
import java.util.List;

public interface CSVFileParser {

    List<User> parseUsersFile(String path) throws IOException;
    List<Address> parserAddressesFile(String uri) throws IOException;

}
