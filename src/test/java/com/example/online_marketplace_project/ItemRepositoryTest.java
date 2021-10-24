package com.example.online_marketplace_project;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback
public class ItemRepositoryTest {
    @Autowired private ItemRepository repo;

    @Test
    public void testAddNew() {
        Item item = new Item();
        item.setItemName("Munchee Hawaian Cookies 200g");
        item.setPrice(450);

        Item savedItem = repo.save(item);

        Assertions.assertThat(savedItem).isNotNull();
        Assertions.assertThat(savedItem.getId()).isGreaterThan(0);
    }



}
