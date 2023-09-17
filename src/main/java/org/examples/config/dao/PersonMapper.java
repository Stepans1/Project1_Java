package org.examples.config.dao;


import javax.swing.tree.TreePath;

import org.examples.config.models.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {


    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
       Person person=new Person();
        person.setId(rs.getInt("id"));
        person.setSurname(rs.getString("name"));
        return person;
    }
}
