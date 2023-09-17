package org.examples.config.models;


public class Book {

    private int id;


    private String name;

    private String author;

    private int realise_year;

//    private int user_id;

    public Book(int id, String name, String author, int realise_year, int userId) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.realise_year = realise_year;
//        this.user_id = userId;
    }


    public Book(){

    }


//    public int getUser_id() {
//        return user_id;
//    }

//    public void setUser_id(int user_id) {
//        this.user_id = user_id;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRealise_year() {
        return realise_year;
    }

    public void setRealise_year(int realise_year) {
        this.realise_year = realise_year;
    }
}
