package com.myrecipes.frontend.service;

import com.myrecipes.frontend.controller.BackendController;
import com.myrecipes.frontend.domain.Ingredient;
import com.myrecipes.frontend.domain.Recipe;
import com.myrecipes.frontend.service.dummydata.DummyData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeService {

    @Autowired
    private final DummyData dummyData;

    @Autowired
    private final BackendController backendController;

    public Recipe getDummyData() {
        return dummyData.getDummyRecipe();
    }

    public void addRecipe(Recipe recipe) {
        dummyData.addRecipe(recipe);
    }

    public List<Ingredient> getDummyIngredients() {
        return dummyData.getIngredients();
    }

    public List<Recipe> findRecipeByName(String name) {  //todo
        return dummyData.getRecipes().stream().filter(recipe ->
                recipe.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Ingredient> findIngredientByName(String name) {  //todo
        return dummyData.getIngredients().stream().filter(ingredient ->
                ingredient.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Recipe> findAllRecipes() {
        return dummyData.getRecipes();
    }
}
