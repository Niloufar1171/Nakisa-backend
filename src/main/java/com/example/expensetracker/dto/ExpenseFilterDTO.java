package com.example.expensetracker.dto;

import java.time.LocalDate;

public class ExpenseFilterDTO {
    private String category;
    private Double minAmount;
    private Double maxAmount;
    private LocalDate startDate;
    private LocalDate endDate;

    public ExpenseFilterDTO(String category, Double minAmount, Double maxAmount, LocalDate startDate, LocalDate endDate) {
        this.category = category;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "ExpenseFilter{" +
                "category='" + category + '\'' +
                ", minAmount=" + minAmount +
                ", maxAmount=" + maxAmount +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Double minAmount) {
        this.minAmount = minAmount;
    }

    public Double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
