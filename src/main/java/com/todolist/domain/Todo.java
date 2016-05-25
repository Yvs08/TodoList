package com.todolist.domain;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "Todo")
public class Todo {

    @Id
    private String id;
    private String number;
    private String title;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date startDate;

    private String description;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dateDeadline;

    private String state;

    public Todo(String number, String title, String description, Date startDate, Date dateDeadline, String state) {
        this.number = number;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.dateDeadline = dateDeadline;
        this.state = state;
    }

    public Todo() {
       
    }

    public Todo(String number, String title, String description) {
         this.number = number;
         this.title = title;
         this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDeadline() {
        return dateDeadline;
    }

    public void setDateDeadline(Date dateDeadline) {
        this.dateDeadline = dateDeadline;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Todo{" + "id=" + id + ", number=" + number + ", title=" + title + ", startDate=" + startDate + ", description=" + description + ", dateDeadline=" + dateDeadline + ", state=" + state + '}';
    }
    
    
    
}
