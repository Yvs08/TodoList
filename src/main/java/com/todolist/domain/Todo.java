package com.todolist.domain;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "Todo")
public class Todo {

    @Id
    private String id;
    private String numero;
    private String titre;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date dateDeCréation;

    private String desccription;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date dateDeCheance;

    private String etat;

    public Todo(String numero, String titre, String desccription, Date dateDeCréation, Date dateDeCheance, String etat) {
        this.numero = numero;
        this.titre = titre;
        this.dateDeCréation = dateDeCréation;
        this.desccription = desccription;
        this.dateDeCheance = dateDeCheance;
        this.etat = etat;
    }

    public Todo() {
       
    }

    public Todo(String numero, String titre, String desccription) {
         this.numero = numero;
         this.titre = titre;
         this.desccription = desccription;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDateDeCréation() {
        return dateDeCréation;
    }

    public void setDateDeCréation(Date dateDeCréation) {
        this.dateDeCréation = dateDeCréation;
    }

    public String getDesccription() {
        return desccription;
    }

    public void setDesccription(String desccription) {
        this.desccription = desccription;
    }

    public Date getDateDeCheance() {
        return dateDeCheance;
    }

    public void setDateDeCheance(Date dateDeCheance) {
        this.dateDeCheance = dateDeCheance;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Todo{" + "id=" + id + ", numero=" + numero + ", titre=" + titre + ", dateDeCr\u00e9ation=" + dateDeCréation + ", desccription=" + desccription + ", dateDeCheance=" + dateDeCheance + ", etat=" + etat + '}';
    }
    
    
    
}
