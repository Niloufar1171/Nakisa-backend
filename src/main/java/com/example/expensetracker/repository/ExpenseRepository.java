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
        "(:category IS NULL OR e.category = :category) AND " +
        "(:startDate IS NULL OR e.date >= :startDate) AND " +
        "(:endDate IS NULL OR e.date <= :endDate) AND " +
        "(:minAmount IS NULL OR e.amount >= :minAmount) AND " +
        "(:maxAmount IS NULL OR e.amount <= :maxAmount)")
Page<Expense> filterExpenses(@Param("category") String category,
                             @Param("startDate") LocalDate startDate,
                             @Param("endDate") LocalDate endDate,
                             @Param("minAmount") Double minAmount,
                             @Param("maxAmount") Double maxAmount,
                             Pageable pageable);
}