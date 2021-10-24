package com.example.online_marketplace_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ItemController {
    @Autowired private ItemService service;

    @GetMapping("/items")
    public String showItemList(Model model) {
        List<Item> listItems = service.listAll();
        model.addAttribute("listItems", listItems);

        return "items";
    }

    @GetMapping("/items/new")
    public String showNewForm(Model model) {
        model.addAttribute("item", new Item());
        model.addAttribute("pageTitle", "Add New Item");
        return "item_form";
    }

    @PostMapping("/items/save")
    public String saveItem(Item item, RedirectAttributes ra) {
        service.save(item);
        ra.addFlashAttribute("message", "The user has been saved successful");
        return "redirect:/items";
    }

}
