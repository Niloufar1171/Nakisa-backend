package src.main.java.com.example.expensetracker.model;

import com.example.expensetracker.model.Expense;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseTest {
    @Test
    public void testExpenseEntity() {
        Expense expense = new Expense();
        expense.setId(1L);
        expense.setAmount(100.0);
        expense.setCategory("Test Expense");

        assertThat(expense.getId()).isEqualTo(1L);
        assertThat(expense.getAmount()).isEqualTo(100.0);
        assertThat(expense.getCategory()).isEqualTo("Test Expense");
    }
}