package com.epam.springprofiles.parser.impl;

import com.epam.springprofiles.model.Address;
import com.epam.springprofiles.model.User;
import com.epam.springprofiles.parser.CSVFileParser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class DefaultCSVFileParser implements CSVFileParser {

    private static final String ID = "id";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";

    private static final String STREET = "street";
    private static final String CITY = "city";

    @Override
    public List<User> parseUsersFile(String uri) throws IOException {
        try (final BufferedReader reader = createReader(uri);
        final CSVParser parser = createUserParser(reader)) {

            return parseUsers(parser);
        }
    }

    @Override
    public List<Address> parserAddressesFile(String uri) throws IOException {
        try (final BufferedReader reader = createReader(uri);
             final CSVParser parser = createAddressParser(reader)) {

            return parseAddresses(parser);
        }
    }

    private BufferedReader createReader(String uri) throws IOException {
        return Files.newBufferedReader(Paths.get(uri));
    }

    private CSVParser createUserParser(BufferedReader reader) throws IOException {
        return new CSVParser(reader, CSVFormat.DEFAULT.withHeader(ID, FIRST_NAME, LAST_NAME)
                .withIgnoreHeaderCase()
                .withTrim());
    }

    private CSVParser createAddressParser(BufferedReader reader) throws IOException {
        return new CSVParser(reader, CSVFormat.DEFAULT.withHeader(ID, STREET, CITY)
                .withIgnoreHeaderCase()
                .withTrim());
    }

    private List<User> parseUsers(CSVParser parser) throws IOException {
        return parser.getRecords().stream()
                .map(this::parseUserRecord)
                .collect(toList());
    }

    private List<Address> parseAddresses(CSVParser parser) throws IOException {
        return parser.getRecords().stream()
                .map(this::parserAddressRecord)
                .collect(toList());
    }

    private User parseUserRecord(CSVRecord record) {
        final User user = new User();
        user.setId(Long.valueOf(record.get(ID)));
        user.setFirstName(record.get(FIRST_NAME));
        user.setLastName(record.get(LAST_NAME));
        return user;
    }

    private Address parserAddressRecord(CSVRecord record) {
        final Address address = new Address();
        address.setId(Long.valueOf(record.get(ID)));
        address.setStreet(record.get(STREET));
        address.setCity(record.get(CITY));
        return address;
    }
}
