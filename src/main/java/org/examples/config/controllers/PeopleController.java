package org.examples.config.controllers;

import org.examples.config.dao.BookDAO;
import org.examples.config.dao.PersonDAO;
import org.examples.config.models.Person;
import org.examples.config.util.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
@RequestMapping("people")
public class PeopleController {

    private final BookDAO bookDAO;
    private final PersonDAO personDAO;
    private final PersonValidator personValidator;
    @Autowired
    public PeopleController(BookDAO bookDAO, PersonDAO personDAO, PersonValidator personValidator){
        this.bookDAO = bookDAO;
        this.personDAO=personDAO;
        this.personValidator = personValidator;
    }

    @GetMapping("")
    public String index( Model model) {

        model.addAttribute("people",personDAO.index());

        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(Model model, @PathVariable int id) {
        model.addAttribute("book",bookDAO.show(id));
        model.addAttribute("person",personDAO.show(id));

        return "people/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable int id) {

        model.addAttribute("person",personDAO.show(id));

        return "people/edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("person")  Person person , @PathVariable int id) throws SQLException {

        personDAO.update(id,person);

        return "people/show";
    }


    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person",new Person());
        return "people/new";
    }

    @PostMapping
    public String create(@ModelAttribute("person")Person person) throws SQLException {


        personDAO.save(person);
        return "redirect:/people";
    }

    @PostMapping("del/{id}")
    public String del(@PathVariable("id") int id) throws SQLException {
        personDAO.del(id);
        return "redirect:/people";
    }
}
