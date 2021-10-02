package com.myrecipes.frontend.service;

import com.myrecipes.frontend.controller.BackendController;
import com.myrecipes.frontend.domain.Ingredient;
import com.myrecipes.frontend.domain.Recipe;
import com.myrecipes.frontend.service.dummydata.DummyData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return dummyData.getDummyIngredients();
    }
}
