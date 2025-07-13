package com.codewithudo.recipemanagementapi.controller;

import com.codewithudo.recipemanagementapi.model.Recipe;
import com.codewithudo.recipemanagementapi.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    // Add a new recipe
    @PostMapping
    public ResponseEntity<String> addRecipe(@RequestBody Recipe recipe) {
        boolean added = recipeService.addRecipe(recipe);
        if (added) {
            return new ResponseEntity<>("Recipe added successfully.", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Failed to add recipe.", HttpStatus.BAD_REQUEST);
    }

    // Get all recipes
    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        return new ResponseEntity<>(recipeService.getAllRecipes(), HttpStatus.OK);
    }

    // Get a recipe by ID
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable int id) {
        Recipe recipe = recipeService.getRecipeById(id);
        if (recipe != null) {
            return new ResponseEntity<>(recipe, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Update a recipe
    @PutMapping("/{id}")
    public ResponseEntity<String> updateRecipe(@PathVariable int id, @RequestBody Recipe recipe) {
        boolean updated = recipeService.updateRecipe(id, recipe);
        if (updated) {
            return new ResponseEntity<>("Recipe updated successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Recipe not found.", HttpStatus.NOT_FOUND);
    }

    // Delete a recipe
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecipe(@PathVariable int id) {
        boolean deleted = recipeService.deleteRecipeById(id);
        if (deleted) {
            return new ResponseEntity<>("Recipe deleted successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Recipe not found.", HttpStatus.NOT_FOUND);
    }
}
