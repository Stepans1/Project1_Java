package org.examples.config.dao;

import org.examples.config.models.Book;
import org.examples.config.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Person> index() {

        return jdbcTemplate.query("SELECT * FROM Person",new BeanPropertyRowMapper<>(Person.class));

    }


    public Optional<Person> show(String name){
        return jdbcTemplate.query("SELECT * FROM Person WHERE surname=?",new Object[]{name},new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public Person show( int id) {


      return jdbcTemplate.query("SELECT * FROM Person where id=?",new Object[]{id},new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }



    public void save(Person person) throws SQLException {
      jdbcTemplate.update("INSERT INTO Person(surname,birthday) VALUES (?,?)",person.getSurname(),person.getBirthday());
    }

    public void update(int id ,Person updatePerson) throws SQLException {
        jdbcTemplate.update("UPDATE  Person SET surname=? , birthday=? where id=?",updatePerson.getSurname(),updatePerson.getBirthday(),updatePerson.getId());

    }

    public void del(int id) throws SQLException {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?",id);

    }

    public List<Person> allPeople(){
      return   jdbcTemplate.query("select * from person ",new BeanPropertyRowMapper<>(Person.class));
    }





}
