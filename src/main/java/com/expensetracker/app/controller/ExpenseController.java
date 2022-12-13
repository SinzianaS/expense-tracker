package com.expensetracker.app.controller;

import com.expensetracker.app.model.Expense;
import com.expensetracker.app.repository.ExpenseRepository;
import com.expensetracker.app.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ExpenseController {
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expenses")         //get all expenses
    List<Expense> getExpenses() {
        //return expenseRepository.findAll();
        return expenseService.getAllExpenses();
    }

    @RequestMapping("/expenses/{id}")
    public Expense getExpenseById(@PathVariable Long id){
        return expenseService.getExpense(id);
    }

    @PostMapping("/expenses")    //create new expense
    ResponseEntity<Expense> createExpense(@Valid @RequestBody Expense expense) throws URISyntaxException {
        Expense result= expenseRepository.save(expense);
        return ResponseEntity.created(new URI("/api/expenses" + result.getExpenseId())).body(result);
    }
    @DeleteMapping("/expenses/{id}")
    ResponseEntity<?> deleteExpense(@PathVariable Long id) {
        expenseRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
