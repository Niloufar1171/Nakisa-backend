package src.main.java.com.example.expensetracker.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
class ExpenseServiceTest {

    @Mock
    private com.example.expensetracker.repository.ExpenseRepository expenseRepository;

    @InjectMocks
    private com.example.expensetracker.service.ExpenseService expenseService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenCreateExpense_thenExpenseIsSaved() {
        com.example.expensetracker.model.Expense expense = new com.example.expensetracker.model.Expense("Lunch", 15.0, LocalDate.now());
        when(expenseRepository.save(any(com.example.expensetracker.model.Expense.class))).thenReturn(expense);

        com.example.expensetracker.model.Expense createdExpense = expenseService.createExpense(expense);

        assertNotNull(createdExpense);
        assertEquals("Lunch", createdExpense.getCategory());
        verify(expenseRepository).save(expense);
    }
}