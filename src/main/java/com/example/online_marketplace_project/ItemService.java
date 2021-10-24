package com.example.online_marketplace_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired private ItemRepository repo;

    public List<Item> listAll() {
        return(List<Item>) repo.findAll();
    }

    public void save(Item item) {
        repo.save(item);
    }
}
