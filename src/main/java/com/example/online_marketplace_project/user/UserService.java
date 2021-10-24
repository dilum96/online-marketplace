package com.example.online_marketplace_project.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired private userRepository repo;

    public List<user> listAll() {
        return (List<user>) repo.findAll();
    }

    public void save(user user) {
        repo.save(user);
    }

    public user get(Integer id) throws UserNotFoundException {
        Optional<user> result = repo.findById(id);
        if(result.isPresent()) {
            return result.get();
        }
        throw  new UserNotFoundException("Could not find any users with Id" + id);
    }

    public void delete(Integer id) throws UserNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new UserNotFoundException("Could not find any users with Id" + id);
        }
        repo.deleteById(id);
    }
}
