package com.codewithudo.basicexpensetrackerapi.controller;

import com.codewithudo.basicexpensetrackerapi.model.Expense;
import com.codewithudo.basicexpensetrackerapi.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<ArrayList<Expense>> getExpenses() {
        ArrayList<Expense> expenses = expenseService.getAllExpenses();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Integer id) {
        Expense expense = expenseService.getExpenseById(id);
        return new ResponseEntity<>(expense, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createExpense(@RequestBody Expense expense) {
        boolean added = expenseService.addExpense(expense);
        if (added) {
            return new ResponseEntity<>("Expense added successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Expense not added", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateExpense(@PathVariable Integer id, @RequestBody Expense expense) {
        boolean updated = expenseService.updateExpense(id, expense);
        if (updated) {
            return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Not Found", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Integer id) {
        boolean deleted = expenseService.deleteExpenseById(id);
        if (deleted) {
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Not Found", HttpStatus.BAD_REQUEST);
        }
    }

}
