package com.eduardo.workshopmongo.dto;

import com.eduardo.workshopmongo.domain.User;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private String id;
    private String name;
    private String email;
    public UserDTO (){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }
}
