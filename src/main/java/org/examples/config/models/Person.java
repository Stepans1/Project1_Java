package org.examples.config.models;

public class Person {

    private int id;

    private String surname;
    private int birthday;



    public Person(int id, String surname, int birthday ) {
        this.id = id;
        this.surname = surname;
        this.birthday=birthday;

    }
    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }





    public Person() {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
