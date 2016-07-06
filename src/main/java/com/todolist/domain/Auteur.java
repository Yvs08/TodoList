package com.todolist.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Auteur")
public class Auteur {

    @Id
    private String id;
    private String name;
    private String function;
    private String department;
    private String society;

    public Auteur() {
    }

    public Auteur(String name, String function, String department, String society) {
        this.name = name;
        this.function = function;
        this.department = department;
        this.society = society;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setSociety(String society) {
        this.society = society;
    }

    public String getName() {
        return name;
    }

    public String getFunction() {
        return function;
    }

    public String getDepartment() {
        return department;
    }

    public String getSociety() {
        return society;
    }

}
