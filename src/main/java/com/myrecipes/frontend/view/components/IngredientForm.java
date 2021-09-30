package com.myrecipes.frontend.view.components;

import com.myrecipes.frontend.domain.Ingredient;
import com.myrecipes.frontend.service.RecipeService;
import com.myrecipes.frontend.view.MainView;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.data.binder.Binder;

public class IngredientForm extends FormLayout {

    private MainView mainView;
    private RecipeService recipeService;
    private Binder<Ingredient> binder = new Binder<>(Ingredient.class);

    public IngredientForm(MainView mainView, RecipeService recipeService) {
        this.recipeService = recipeService;
        this.mainView = mainView;
    }
}
