package com.myrecipes.frontend.service.dummydata;

import com.myrecipes.frontend.domain.Ingredient;
import com.myrecipes.frontend.domain.Recipe;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class DummyData {

    private List<Recipe> recipes;
    List<Ingredient> ingredients;

    public DummyData() {
        recipes = new ArrayList<>();
        recipes.add(getDummyRecipe());
        ingredients = new ArrayList<>();
    }

    public Recipe getDummyRecipe() {

        Ingredient ingredient1 = new Ingredient(1, "ingr 1", 1, 11, 111, 12, 200);
        Ingredient ingredient2 = new Ingredient(2, "ingr 2", 1, 12, 222, 12, 200);
        Ingredient ingredient3 = new Ingredient(3, "ingr 3", 1, 13, 333, 12, 200);
        Ingredient ingredient4 = new Ingredient(4, "ingr 4", 1, 14, 444, 12, 200);
        Ingredient ingredient5 = new Ingredient(5, "ingr 5", 1, 15, 555, 12, 200);

        String spice1 = "spice 1";
        String spice2 = "spice 2";

        Recipe recipe = new Recipe("dummy recipe 1","dummy desc 1", 60);

        recipe.addIngredient(ingredient1);
        recipe.addIngredient(ingredient2);
        recipe.addIngredient(ingredient3);
        recipe.addIngredient(ingredient4);
        recipe.addIngredient(ingredient5);
        recipe.addSpice(spice1);
        recipe.addSpice(spice2);

        return recipe;
    }

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    public void updateRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    public void removeRecipe(Recipe recipe) {
        recipes.remove(recipe);
    }

    public List<Ingredient> getDummyIngredients() {

        Ingredient ingredient1 = new Ingredient(1, "found 1", 1, 11, 111, 12, 400);
        Ingredient ingredient2 = new Ingredient(2, "found 2", 1, 12, 222, 12, 400);
        Ingredient ingredient3 = new Ingredient(3, "found 3", 1, 13, 333, 12, 400);
        Ingredient ingredient4 = new Ingredient(4, "found 4", 1, 14, 444, 12, 400);
        Ingredient ingredient5 = new Ingredient(5, "found 5", 1, 15, 555, 12, 400);

        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        ingredients.add(ingredient3);
        ingredients.add(ingredient4);
        ingredients.add(ingredient5);

        return ingredients;
    }
}
