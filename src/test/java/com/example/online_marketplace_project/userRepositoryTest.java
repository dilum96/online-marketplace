package com.example.online_marketplace_project;

import com.example.online_marketplace_project.user.user;
import com.example.online_marketplace_project.user.userRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class userRepositoryTest {
    @Autowired private userRepository repo;

    @Test
    public void testAddNew() {
        user user = new user();
        user.setEmail("dilumtharaka@gmail.com");
        user.setPassword("67890");
        user.setFirstName("Tharaka");
        user.setLastName("Samararathna");

        user savedUser = repo.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }
    @Test
    public void testListAll() {
        Iterable<user> users = repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for(user user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testUpdate() {
        Integer userId = 1;
        Optional<user> optionalUser = repo.findById(userId);
        user user = optionalUser.get();
        repo.save(user);

        user updatedUser = repo.findById(userId).get();
        Assertions.assertThat(updatedUser.getPassword()).isEqualTo("12345");
    }

    @Test
    public void testGet() {
        Integer userId = 1;
        Optional<user> optionalUser = repo.findById(userId);
        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());

    }

    @Test
    public void testDelete() {
        Integer userId = 1;
        repo.deleteById(userId);

        Optional<user> optionalUser = repo.findById(userId);
        Assertions.assertThat(optionalUser).isNotPresent();


    }

}
