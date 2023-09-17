package org.examples.config.controllers;

import org.examples.config.dao.BookDAO;
import org.examples.config.dao.PersonDAO;
import org.examples.config.models.Book;
import org.examples.config.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
@RequestMapping("book")
public class BookController {


    private final BookDAO bookDAO;
    private final PersonDAO personDAO;

    public BookController(BookDAO bookDAO, PersonDAO personDAO) {
        this.bookDAO = bookDAO;

        this.personDAO = personDAO;
    }

    @GetMapping("")
    public String index( Model model) throws SQLException {

        model.addAttribute("books",bookDAO.index());

        return "book/index";
    }

    @GetMapping("/{id}")
    public String show(Model model,@PathVariable int id){

        model.addAttribute("people",personDAO.allPeople());
        model.addAttribute("book",bookDAO.show2(id));
        return "book/show";
    }

    @GetMapping("/new")
    public String newBook(Model model){
        model.addAttribute("book",new Book());
        return "book/new";
    }

    @PostMapping
    public String save(@ModelAttribute("book")Book book){
        bookDAO.save(book);
        return "redirect:/book";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable int id) {

        model.addAttribute("book",bookDAO.show2(id));

        return "book/edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("book") Book book , @PathVariable int id) throws SQLException {

        bookDAO.update(id,book);

        return "redirect:/book";
    }

    @PostMapping("del/{id}")
    public String del(@PathVariable("id") int id) throws SQLException {
        bookDAO.del(id);
        return "redirect:/book";
    }
    @PostMapping("/set")
    public String add(@ModelAttribute("person") Person person){
        System.out.println(person.getId());
        return "redirect:/book";
    }

}
