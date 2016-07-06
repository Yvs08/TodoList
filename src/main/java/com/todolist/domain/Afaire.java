
package com.todolist.domain;

import javax.persistence.ManyToOne;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Afaire")
public class Afaire {

    @Id
    private String id;
    private String number;
    private String title;

    private String startDate;

    private String description;

    private String dateDeadline;

    private String state;

    @ManyToOne
    private Auteur auteur;

    public Afaire(String number, String title, String startDate, String description, String dateDeadline, String state, Auteur auteur) {
        this.number = number;
        this.title = title;
        this.startDate = startDate;
        this.description = description;
        this.dateDeadline = dateDeadline;
        this.state = state;
        this.auteur = auteur;
    }

    public Afaire() {

    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateDeadline(String dateDeadline) {
        this.dateDeadline = dateDeadline;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public String getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getDescription() {
        return description;
    }

    public String getDateDeadline() {
        return dateDeadline;
    }

    public String getState() {
        return state;
    }

    public Auteur getAuteur() {
        return auteur;
    }

}
