package com.codewithudo.basiccalculatorapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class CalculatorController {

    @GetMapping("/add")
    public Map<String, Object> add(@RequestParam("a") Integer a, @RequestParam("b") Integer b){
        double sum = a + b;
        return Map.of(
                "operation", "addition",
                "result", sum);
    }

    @GetMapping("/subtract")
    public Map<String, Object> subtract(@RequestParam("a") Integer a, @RequestParam("b") Integer b){
        double sub = a - b;
        return Map.of(
                "operation", "subtraction",
                "result", sub);
    }

    @GetMapping("/multiply")
    public Map<String, Object> multiply(@RequestParam("a") Integer a, @RequestParam("b") Integer b){
        double quotient = a * b;
        return Map.of(
                "operation", "multiplication",
                "result", quotient);
    }

    @GetMapping("/divide")
    public Map<String, Object> divide(@RequestParam("a") Integer a, @RequestParam("b") Integer b){
        if(b == 0){
            return Map.of(
                    "operation", "division",
                    "error", "Cannot divide by zero"
            );
        }
        double dividend = a / b;
        return Map.of(
                "operation", "division",
                "result", dividend);
    }

}
