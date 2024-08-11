package org.example.finalexamprep2;

import jakarta.persistence.Id;

public class Customer {
    @Id
    private int id;
    private String name;
    private String type;
    private double deposit;
    private int year;

    // Constructors
    public Customer() {}

    public Customer(int id, String name, String type, double deposit, int year) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.deposit = deposit;
        this.year = year;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {return year;}

    public void setYear(int year) {this.year = year;}

}

