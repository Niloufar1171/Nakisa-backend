package com.example.expensetracker.controller;

import com.example.expensetracker.dto.ExpenseFilterDTO;
import com.example.expensetracker.model.Expense;
import com.example.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }

    //Add new end point for filtering the expenses using post for complex queries  1-
    // POST filtering with DTO
    @PostMapping("/filters")
    public Page<Expense> filterExpensesPost(
            @RequestBody ExpenseFilterDTO filter,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return expenseService.filterExpenses(filter, pageable);
    }

    //Add new end point for filtering the expenses using get for simple filtering no nesting
    @GetMapping("/filters")
    public Page<Expense> filterExpenses(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(required = false) Double minAmount,
            @RequestParam(required = false) Double maxAmount,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return expenseService.filterExpensesByParams(category, startDate, endDate, minAmount, maxAmount, pageable);
    }
//    @PostMapping
//    public ResponseEntity<?> createExpense(@Valid @RequestBody Expense expense, BindingResult result) {
//        if (result.hasErrors()) {
//            StringBuilder errors = new StringBuilder();
//            for (FieldError error : result.getFieldErrors()) {
//                errors.append(error.getField()).append(": ").append(error.getDefaultMessage()).append("\n");
//            }
//            return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
//        }
//         expenseService.createExpense(expense);
//        return new ResponseEntity<>(expense,HttpStatus.CREATED);
//    }
    @PostMapping
    public ResponseEntity<Expense> createExpense(@Valid @RequestBody Expense expense) {
            return new ResponseEntity<>( expenseService.createExpense(expense), HttpStatus.BAD_REQUEST);
        }
    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        return expenseService.updateExpense(id, expense);
    }
//Change delete to put deleted items in the past month in an archive
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> softDeleteExpense(@PathVariable Long id) {
        expenseService.archiveExpense(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/archived")
    public List<Expense> getArchived() {
        return   expenseService.getArchivedExpenses();
    }
}