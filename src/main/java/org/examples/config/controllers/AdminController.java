package org.examples.config.controllers;

import org.examples.config.dao.BookDAO;
import org.examples.config.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {


    private final BookDAO bookDAO;
    public AdminController(BookDAO bookDAO) {


        this.bookDAO = bookDAO;
    }

    @PostMapping()
    public void add(@ModelAttribute("person1")Person person){
    System.out.println(person.getId());
    }

}
