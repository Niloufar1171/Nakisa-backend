package com.example.expensetracker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Entity
public class Expense {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   // private String description;

    private String category;

    @Min(value = 1, message = "Amount must be greater than 0")
    private Double amount;


    @PastOrPresent(message = "Date cannot be in the future")
    private LocalDate date;

    // Constructors
    public Expense() {}

    public Expense(String category, Double amount, LocalDate date) {
        this.category= category;
        this.amount = amount;
        this.date = date;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}
