package models;

import java.time.LocalDate;

public class User {

    private Integer id;
    private String user;
    private String name;
    private LocalDate dob;
    private String city;
    private String country;

    private String pass;

    public User() {
    }

    public User(Integer id, String user, String name, LocalDate dob, String city, String country, String pass) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.dob = dob;
        this.city = city;
        this.country = country;
        this.pass = pass;
    }

    public User(String user, String name, LocalDate dob, String city, String country, String pass) {
        this.user = user;
        this.name = name;
        this.dob = dob;
        this.city = city;
        this.country = country;
        this.pass = pass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
