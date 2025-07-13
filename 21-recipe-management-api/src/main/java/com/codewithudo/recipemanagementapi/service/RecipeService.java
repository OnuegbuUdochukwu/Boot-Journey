package com.codewithudo.recipemanagementapi.service;

import com.codewithudo.recipemanagementapi.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    private final List<Recipe> recipes = new ArrayList<>();
    private int nextId = 1;

    // Add a new recipe
    public boolean addRecipe(Recipe recipe) {
        recipe.setId(nextId++);
        recipes.add(recipe);
        return true;
    }

    // Get all recipes
    public List<Recipe> getAllRecipes() {
        return recipes;
    }

    // Get a recipe by ID
    public Recipe getRecipeById(int id) {
        for (Recipe recipe : recipes) {
            if (recipe.getId().equals(id)) {
                return recipe;
            }
        }
        return null;
    }

    // Update an existing recipe
    public boolean updateRecipe(int id, Recipe updatedRecipe) {
        for (Recipe recipe : recipes) {
            if (recipe.getId().equals(id)) {
                recipe.setTitle(updatedRecipe.getTitle());
                recipe.setDescription(updatedRecipe.getDescription());
                recipe.setIngredients(updatedRecipe.getIngredients());
                recipe.setInstructions(updatedRecipe.getInstructions());
                recipe.setCategory(updatedRecipe.getCategory());
                return true;
            }
        }
        return false;
    }

    // Delete a recipe by ID
    public boolean deleteRecipeById(int id) {
        return recipes.removeIf(recipe -> recipe.getId().equals(id));
    }
}
