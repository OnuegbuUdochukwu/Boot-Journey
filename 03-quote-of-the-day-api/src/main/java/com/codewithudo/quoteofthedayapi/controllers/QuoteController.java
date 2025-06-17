package com.codewithudo.quoteofthedayapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import java.util.LinkedHashMap;
import java.util.*;

@RestController
public class QuoteController {
    // Step 1: Create a LinkedHashMap to preserve insertion order (optional)
    private final List<Map<String, String>> quotes = List.of(
            Map.of(
                    "quote", "The best way to predict the future is to create it.",
                    "author", "Peter Drucker"
            ),
            Map.of(
                    "quote", "Do not wait to strike till the iron is hot; but make it hot by striking.",
                    "author", "William Butler Yeats"
            ),
            Map.of(
                    "quote", "Whether you think you can or you think you can't, you're right.",
                    "author", "Henry Ford"
            ),
            Map.of(
                    "quote", "Success is not the key to happiness. Happiness is the key to success.",
                    "author", "Albert Schweitzer"
            )
    );


    Random random = new Random();

    @GetMapping("/quote")
    public Map<String, String> getRandomQuote(@RequestParam(required = false, defaultValue = "false") boolean author) {
        Map<String, String> selectedQuote = quotes.get(random.nextInt(quotes.size()));

        if (author) {
            return selectedQuote;
        } else {
            return Map.of("quote", selectedQuote.get("quote"));
        }
    }
}
