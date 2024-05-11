package com.example.nameservice.service;

import com.example.nameservice.Name;
import com.example.nameservice.NameNotFoundException;
import com.example.nameservice.mapper.NameMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NameService {

    private NameMapper nameMapper;

    public NameService(NameMapper nameMapper) {
        this.nameMapper = nameMapper;
    }

    public List<Name> findNamesStartingWith(String prefix) {
        return nameMapper.findByNameStartingWith(prefix);
    }

    public Name findName(int id) {
        Optional<Name> name = nameMapper.findById(id);
        if (name.isPresent()) {
            return name.get();
        } else {
            throw new NameNotFoundException("name not found");
        }
    }

}
