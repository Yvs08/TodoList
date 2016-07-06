package com.todolist.domain;

public class Project {

    private String name;
    private String function;
    private String department;
    private String society;
    private String number;
    private String title;

    private String startDate;

    private String description;

    private String dateDeadline;

    public Project() {
    }

    public Project(String name, String function, String department, String society, String number, String title, String startDate, String description, String dateDeadline) {
        this.name = name;
        this.function = function;
        this.department = department;
        this.society = society;
        this.number = number;
        this.title = title;
        this.startDate = startDate;
        this.description = description;
        this.dateDeadline = dateDeadline;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSociety(String society) {
        this.society = society;
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

}
