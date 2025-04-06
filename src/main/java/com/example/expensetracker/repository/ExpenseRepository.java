package com.example.expensetracker.repository;

import com.example.expensetracker.model.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    @Query("SELECT e FROM Expense e WHERE " +
            "(:description IS NULL OR e.description = :description) AND " +
            "(:startDate IS NULL OR e.date >= :startDate) AND " +
            "(:endDate IS NULL OR e.date <= :endDate) AND " +
            "(:minAmount IS NULL OR e.amount >= :minAmount) AND " +
            "(:maxAmount IS NULL OR e.amount <= :maxAmount)")
    Page<Expense> filterExpenses(@Param("description") String description,
                                 @Param("startDate") LocalDate startDate,
                                 @Param("endDate") LocalDate endDate,
                                 @Param("minAmount") Double minAmount,
                                 @Param("maxAmount") Double maxAmount,
                                 Pageable pageable);
}