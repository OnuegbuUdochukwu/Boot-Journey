package com.codewithudo.basicexpensetrackerapi.service;

import com.codewithudo.basicexpensetrackerapi.model.Expense;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ExpenseService {

    private final ArrayList<Expense> expenses = new ArrayList<>();
    int nextId = 1;

    public boolean addExpense(Expense expense) {
        expenses.add(expense);
        if (expense.getTitle() == null) {
            return false;
        }
        expense.setId(nextId++);
        return true;
    }

    public ArrayList<Expense> getAllExpenses() {
        return expenses;
    }

    public Expense getExpenseById(int id) {
        for (Expense expense : expenses) {
            if (expense.getId() == id) {
                return expense;
            }
        }
        return null;
    }

    public boolean updateExpense(int id, Expense updatedExpense) {
        for (Expense expense : expenses) {
            if (expense.getId() == id) {
                expense.setTitle(updatedExpense.getTitle());
                expense.setAmount(updatedExpense.getAmount());
                expense.setCategory(updatedExpense.getCategory());
                expense.setDate(updatedExpense.getDate());
                return true;
            }
        }
        return false;
    }

    public boolean deleteExpenseById(int id) {
        for (Expense expense : expenses) {
            if (expense.getId() == id) {
                expenses.remove(expense);
                return true;
            }
        }
        return false;
    }
}
