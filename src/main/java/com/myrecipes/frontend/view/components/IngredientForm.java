package com.myrecipes.frontend.view.components;

import com.myrecipes.frontend.domain.Ingredient;
import com.myrecipes.frontend.service.RecipeService;
import com.myrecipes.frontend.view.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.value.HasValueChangeMode;
import com.vaadin.flow.data.value.ValueChangeMode;

public class IngredientForm extends VerticalLayout {

    private MainView mainView;
    private RecipeService recipeService;

    private Button addIngredient = new Button("Add ingredient", new Icon(VaadinIcon.PLUS));
    private Grid<Ingredient> suggestedIngr = new Grid<>(Ingredient.class);
    private TextField name = new TextField("Name");
    private TextField amount = new TextField("Amount in grams");
    private TextField protein = new TextField("Protein/100gr");
    private TextField carbohydrates = new TextField("Carbohydrates/100gr");
    private TextField fat = new TextField("Fat/100gr");
    private TextField caloriesPer100Gr = new TextField("Calories/100gr");
    private TextField typeIngr = new TextField("Find ingredient in Spoonacular: ");
    private FormLayout nutritionInfoFields = new FormLayout(name, amount, protein, carbohydrates, fat, caloriesPer100Gr);
    private VerticalLayout gridLayout = new VerticalLayout();
    private HorizontalLayout buttonsBar = new HorizontalLayout();
    private Binder<Ingredient> ingredientBinder = new Binder<>(Ingredient.class);

    public IngredientForm(MainView mainView, RecipeService recipeService) {
        this.recipeService = recipeService;
        this.mainView = mainView;
        setSizeFull();
        configureButtons();
        configureButtonsBar();
        configureGrids();
        configureGridsLayout();
        add(nutritionInfoFields, gridLayout, buttonsBar);
    }

    private void configureButtons() {
        addIngredient.getStyle().set("border", "3px solid #9E9E9E");
    }

    private void configureButtonsBar() {
        buttonsBar.setWidth("100%");
        buttonsBar.add(addIngredient);
        buttonsBar.getStyle().set("border", "3px solid #4B9DFF");
    }

    private void configureGrids() {
        suggestedIngr.setSizeFull();
        suggestedIngr.setColumns("name", "amount", "protein",
                "carbohydrates", "fat");
       // suggestedIngr.setItems(recipeService.getDummyIngredients()); todo
        suggestedIngr.setItems(recipeService.getDummyIngredients());
        suggestedIngr.addColumn(Ingredient::getCaloriesPer100Gr).setHeader("Calories/100g");
        suggestedIngr.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private void configureGridsLayout() {
        typeIngr.setPlaceholder(" ... type here ...");
        typeIngr.setClearButtonVisible(true);
        typeIngr.setValueChangeMode(ValueChangeMode.LAZY);
        typeIngr.setValueChangeTimeout(HasValueChangeMode.DEFAULT_CHANGE_TIMEOUT);
        typeIngr.addValueChangeListener(event -> updateSuggestedIngrGrid());
        gridLayout.setSizeFull();
        gridLayout.add(typeIngr, suggestedIngr);
    }

    private void updateSuggestedIngrGrid() {
        suggestedIngr.setItems(recipeService.findIngredientByName(typeIngr.getValue()));
    }
}
