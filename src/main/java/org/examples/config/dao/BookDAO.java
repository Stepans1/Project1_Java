package org.examples.config.dao;

import org.examples.config.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class BookDAO {

    private  final JdbcTemplate jdbcTemplate;


    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate, PersonDAO personDAO) {
        this.jdbcTemplate = jdbcTemplate;

    }


    public List<Book> index() throws SQLException {
        return jdbcTemplate.query("SELECT * FROM Book",new BeanPropertyRowMapper<>(Book.class));
    }



    public  List<Book> show(int id){
        return jdbcTemplate.query("SELECT name,author,realise_year FROM Book WHERE user_id=?",new Object[]{id},new BeanPropertyRowMapper<>(Book.class));
    }




    public  Book show2(int id){
        return jdbcTemplate.query("SELECT * FROM Book where id=?",new Object[]{id},new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }
    public void save(Book book){
         jdbcTemplate.update("INSERT INTO Book(name,author,realise_year) values (?,?,?)",book.getName(),book.getAuthor(),book.getRealise_year()) ;

    }

    public void update(int id, Book book) {
        jdbcTemplate.update("UPDATE  Book SET name=? , author=?, realise_year=? where id=?",book.getName(),book.getAuthor(),book.getRealise_year(),book.getId());

    }

    public void del(int id) throws SQLException {
        jdbcTemplate.update("DELETE FROM Book WHERE id=?",id);

    }
}
