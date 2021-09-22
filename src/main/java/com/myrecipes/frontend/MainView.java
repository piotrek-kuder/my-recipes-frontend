package com.myrecipes.frontend;

import com.myrecipes.frontend.domain.Ingredient;
import com.myrecipes.frontend.domain.Recipe;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("/front")
@PageTitle("Recipes frontend")
public class MainView extends VerticalLayout {

    private HorizontalLayout buttonsBar = new HorizontalLayout();
    private HorizontalLayout gridsBar = new HorizontalLayout();
    private Button addRecipe = new Button("Add recipe", new Icon(VaadinIcon.PLUS));
    private Button editRecipe = new Button("Edit recipe", new Icon(VaadinIcon.EDIT));
    private Button copyRecipe = new Button("Copy recipe", new Icon(VaadinIcon.COPY));
    private Button removeRecipe = new Button("Remove recipe", new Icon(VaadinIcon.MINUS));
    private Button helpButton = new Button("Show help", new Icon(VaadinIcon.ARCHIVE));
    private Button aboutApp = new Button("About", new Icon(VaadinIcon.QUESTION));
    private Button showStats = new Button("Show stats", new Icon(VaadinIcon.CHART));
    private Grid<Recipe> recipeGrid = new Grid<>(Recipe.class);
    private Grid<Ingredient> ingredientGrid = new Grid<>(Ingredient.class);


    public MainView() {
        configureButtons();
        configureButtonsBar(buttonsBar);
        configureGrids();
        configureGridsBar(gridsBar);
        setSizeFull();
        add(buttonsBar, gridsBar);
    }

    private void configureButtons() {
        addRecipe.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_LARGE);
        editRecipe.addThemeVariants(ButtonVariant.LUMO_LARGE);
        copyRecipe.addThemeVariants(ButtonVariant.LUMO_LARGE);
        removeRecipe.addThemeVariants(ButtonVariant.LUMO_LARGE);
    }

    private void configureGrids() {
        recipeGrid.setColumns("name", "cookingTime", "totalCalories"); //todo addColumn setHeader
        ingredientGrid.setColumns("name", "amount", "protein",
                "carbohydrates", "fat", "caloriesPer100Gr");
    }

    private void configureButtonsBar(HorizontalLayout buttonsBar) {
        buttonsBar.add(addRecipe, editRecipe, copyRecipe, removeRecipe, helpButton, aboutApp, showStats);
        buttonsBar.getStyle().set("border", "3px solid #9E9E9E");
    }

    private void configureGridsBar(HorizontalLayout gridsBar) {
        gridsBar.add(recipeGrid, ingredientGrid);
        gridsBar.getStyle().set("border", "3px solid #9E9E9E");
    }
}
