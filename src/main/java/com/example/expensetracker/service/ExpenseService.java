package com.example.expensetracker.service;

import com.example.expensetracker.dto.ExpenseFilterDTO;
import com.example.expensetracker.model.Expense;
import com.example.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
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
            existing.setCategory(expense.getCategory());
            existing.setAmount(expense.getAmount());
            existing.setDate(expense.getDate());
            return expenseRepository.save(existing);
        }
        return null;
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

//Good for nested json and more advance filtering
public Page<Expense> filterExpenses(ExpenseFilterDTO filter, Pageable pageable) {
    return expenseRepository.filterExpenses(
            filter.getCategory(),
            filter.getStartDate(),
            filter.getEndDate(),
            filter.getMinAmount(),
            filter.getMaxAmount(),
            pageable
    );
}
    //for easier filtering
    public Page<Expense> filterExpensesByParams(String category, java.time.LocalDate startDate, java.time.LocalDate endDate,
                                                Double minAmount, Double maxAmount, Pageable pageable) {
        if (category == null || category.isEmpty()) {
            category = null; // If empty, treat it as null
        }
        if (minAmount == null) {
            minAmount = 0.0; // Default min value
        }
        if (maxAmount == null) {
            maxAmount = Double.MAX_VALUE; // No upper limit if maxAmount is null
        }

        // If start or end date are empty, set them to null
        if (startDate != null ) {
            startDate = null;
        }
        if (endDate != null) {
            endDate = null;
        }
        return expenseRepository.filterExpenses(category, startDate, endDate, minAmount, maxAmount, pageable);
    }

}