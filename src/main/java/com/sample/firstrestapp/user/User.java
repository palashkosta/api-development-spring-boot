package com.sample.firstrestapp.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Users description")
public class User {

    private Integer id;

    @ApiModelProperty(notes = "Message should be 2 characters")
    @Size(min = 2, message = "Message should have atleast 2 characters")
    private String name;
    
    @Past
    @ApiModelProperty(notes = "birth date must be in the past")
    private Date birthDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public User(Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User [birthDate=" + birthDate + ", id=" + id + ", name=" + name + "]";
    }

    

}
