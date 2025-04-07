//package com.example.expensetracker.repository;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.assertj.core.api.Assertions.assertThat;
//import java.util.List;
//import com.example.expensetracker.model.Expense;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.ActiveProfiles;
//
//@ActiveProfiles("test")
//@DataJpaTest
//class ExpenseRepositoryTest {
//    @Autowired
//    private ExpenseRepository expenseRepository;
//
//    @Test
//    public void testFindAllExpenses() {
//        List<Expense> expenses = expenseRepository.findAll();
//        assertThat(expenses).isNotEmpty();
//        assertThat(expenses).hasSize(2); // Assuming data.sql inserts two records
//    }
//}