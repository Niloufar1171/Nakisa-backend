package com.example.expensetracker.repository;

import com.example.expensetracker.model.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

//    List<Expense> findByCategoryAndAmountBetweenAndDateBetween(
//            String category, Double minAmount, Double maxAmount, String startDate, String endDate);
@Query("SELECT e FROM Expense e WHERE " +
        "(e.category = :category OR :category IS NULL) AND " +
        "(e.amount >= :minAmount OR :minAmount IS NULL) AND " +
        "(e.amount <= :maxAmount OR :maxAmount IS NULL) AND " +
        "(e.date BETWEEN :startDate AND :endDate)")
Page<Expense> filterExpenses(@Param("category") String category,
                             @Param("startDate") LocalDate startDate,
                             @Param("endDate") LocalDate endDate,
                             @Param("minAmount") Double minAmount,
                             @Param("maxAmount") Double maxAmount,
                             Pageable pageable);
}