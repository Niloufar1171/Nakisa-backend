//package src.main.java.com.example.expensetracker.controller;
//
//import com.example.expensetracker.controller.ExpenseController;
//import com.example.expensetracker.model.Expense;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.web.client.RestTemplate;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.time.LocalDate;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ContextConfiguration(classes = ExpenseController.class)
//public class ExpenseControllerTest2 {
//    @Autowired
//    RestTemplate restTemplate;
//
//    @Test
//    public void testAmountValidation_shouldReturnBadRequest_whenAmountIsLessThanZero() {
//            // Create an expense with an amount less than 0
//            Expense expense = new Expense();
//            expense.setCategory("Test Expense");
//            expense.setAmount(-1.0);  // Invalid amount
//            expense.setDate(LocalDate.now());
//
//            // Send a POST request
//            ResponseEntity<String> response = restTemplate.postForEntity("/api/expenses", expense, String.class);
//
//            // Assert that we get a Bad Request response
//            assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
//            assertThat(response.getBody()).contains("Amount must be greater than 0");
//        }
//
//        @Test
//        public void testDateValidation_shouldReturnBadRequest_whenDateIsInTheFuture() {
//            // Create an expense with a future date
//            Expense expense = new Expense();
//            expense.setCategory("Test Expense");
//            expense.setAmount(100.0);
//            expense.setDate(LocalDate.now().plusDays(1));  // Future date
//
//            // Send a POST request
//            ResponseEntity<String> response = restTemplate.postForEntity("/api/expenses", expense, String.class);
//
//            // Assert that we get a Bad Request response
//            assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
//            assertThat(response.getBody()).contains("Date cannot be in the future");
//        }
//
//        @Test
//        public void testValidExpense_shouldReturnCreated_whenExpenseIsValid() {
//            // Create a valid expense
//            Expense expense = new Expense();
//            expense.setCategory("Test Expense");
//            expense.setAmount(50.0);
//            expense.setDate(LocalDate.now());
//
//            ResponseEntity<String> response = restTemplate.postForEntity("/api/expenses", expense, String.class);
//
//            assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
//        }
//}
