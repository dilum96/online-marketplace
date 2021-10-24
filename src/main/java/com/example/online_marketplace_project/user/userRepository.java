package com.example.online_marketplace_project.user;

import org.springframework.data.repository.CrudRepository;

public interface userRepository extends CrudRepository<user,Integer> {
    public Long countById(Integer id);
}
