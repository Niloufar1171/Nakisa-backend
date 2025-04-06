package com.example.expensetracker.service;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

    public Expense updateExpense(Long id, Expense expense) {
        Expense existing = getExpenseById(id);
        if (existing != null) {
            existing.setDescription(expense.getDescription());
            existing.setAmount(expense.getAmount());
            existing.setDate(expense.getDate());
            return expenseRepository.save(existing);
        }
        return null;
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    public Page<Expense> filterExpenses(String description, LocalDate startDate, LocalDate endDate,
                                        Double minAmount, Double maxAmount, Pageable pageable) {
        return expenseRepository.filterExpenses(description, startDate, endDate, minAmount, maxAmount, pageable);
    }

}