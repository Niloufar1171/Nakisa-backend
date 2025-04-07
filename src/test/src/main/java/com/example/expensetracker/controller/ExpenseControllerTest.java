package src.main.java.com.example.expensetracker.controller;

import com.example.expensetracker.controller.ExpenseController;
import com.example.expensetracker.model.Expense;
import com.example.expensetracker.service.ExpenseService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.Test;

import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ExpenseController.class)
    public class ExpenseControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExpenseService expenseService;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Test
    public void testCreateExpense() throws Exception {
        Expense expense = new Expense();
        expense.setAmount(100.0);
        when(expenseService.createExpense(any(Expense.class))).thenReturn(expense);
        mockMvc.perform(post("/expenses")
                        .contentType("application/json")
                        .content("{\"amount\":100.0}"))
                .andExpect(status().isCreated());

        verify(expenseService, times(1)).createExpense(any(Expense.class));
    }

    }