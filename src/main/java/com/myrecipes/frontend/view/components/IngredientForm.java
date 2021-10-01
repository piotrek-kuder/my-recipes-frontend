package com.myrecipes.frontend.view.components;

import com.myrecipes.frontend.domain.Ingredient;
import com.myrecipes.frontend.service.RecipeService;
import com.myrecipes.frontend.view.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class IngredientForm extends FormLayout {

    private MainView mainView;
    private RecipeService recipeService;
    private TextField name = new TextField("Name");
    private TextField amount = new TextField("Amount in grams");
    private TextField protein = new TextField("Protein/100gr");
    private TextField carbohydrates = new TextField("Carbohydrates/100gr");
    private TextField fat = new TextField("Fat/100gr");
    private TextField caloriesPer100Gr = new TextField("Calories/100gr");
    private Binder<Ingredient> ingredientBinder = new Binder<>(Ingredient.class);

    public IngredientForm(MainView mainView, RecipeService recipeService) {
        this.recipeService = recipeService;
        this.mainView = mainView;
        setSizeFull();
        add(name, amount, protein, carbohydrates, fat, caloriesPer100Gr);
    }
}
