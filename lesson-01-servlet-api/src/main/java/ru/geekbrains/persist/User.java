package ru.geekbrains.persist;

public class User {
    private Long id;
    private String username;

    public User(String username){
        this.username=username;
    }

    public void setId(Long id){
        this.id=id;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public Long getId(){
        return id;
    }

    public String getUsername(){
        return username;
    }
}
