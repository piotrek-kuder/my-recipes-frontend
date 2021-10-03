package com.myrecipes.frontend.view;

import com.myrecipes.frontend.domain.Ingredient;
import com.myrecipes.frontend.domain.Recipe;
import com.myrecipes.frontend.service.RecipeService;
import com.myrecipes.frontend.view.components.IngredientForm;
import com.myrecipes.frontend.view.components.RecipeForm;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("/front")
@PageTitle("Recipes frontend")
public class MainView extends VerticalLayout {

    private RecipeService recipeService;
    private RecipeForm recipeForm;
    private IngredientForm ingredientForm;

    private HorizontalLayout buttonsBar = new HorizontalLayout();
    private HorizontalLayout infoBar = new HorizontalLayout();
    private VerticalLayout recipeSection = new VerticalLayout();
    private Button addRecipe = new Button("Add recipe", new Icon(VaadinIcon.PLUS));
    private Button editRecipe = new Button("Edit recipe", new Icon(VaadinIcon.EDIT));
    private Button copyRecipe = new Button("Copy recipe", new Icon(VaadinIcon.COPY));
    private Button removeRecipe = new Button("Remove recipe", new Icon(VaadinIcon.MINUS));
    private Button helpButton = new Button("Show help", new Icon(VaadinIcon.ARCHIVE));
    private Button aboutApp = new Button("About", new Icon(VaadinIcon.QUESTION));
    private Button showStats = new Button("Show stats", new Icon(VaadinIcon.CHART));
    private TextField findRecipe = new TextField();
    private Grid<Recipe> recipeGrid = new Grid<>(Recipe.class);
    private Grid<Ingredient> ingredientGrid = new Grid<>(Ingredient.class);
    private Paragraph recipeText = new Paragraph("example description");


    public MainView(RecipeService recipeService) {
        this.recipeService = recipeService;
        recipeForm = new RecipeForm(this, recipeService);
        ingredientForm = new IngredientForm(this, recipeService);
        setSizeFull();
        configureButtons();
        configureButtonsBar();
        configureGrids();
        configureInfoBar();
        add(buttonsBar, infoBar);
    }

    private void configureButtons() {
        addRecipe.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_LARGE);
        addRecipe.addClickListener(click -> {
            findRecipe.setEnabled(false);
            editRecipe.setEnabled(false);
            copyRecipe.setEnabled(false);
            removeRecipe.setEnabled(false);
            ingredientGrid.setVisible(false);
            recipeSection.setVisible(false);
            recipeForm.setSizeFull();
            recipeForm.setVisible(true);
            ingredientForm.setVisible(true);
        });

        editRecipe.addThemeVariants(ButtonVariant.LUMO_LARGE);
        editRecipe.getStyle().set("border", "3px solid #9E9E9E");
        editRecipe.setEnabled(false);

        copyRecipe.addThemeVariants(ButtonVariant.LUMO_LARGE);
        copyRecipe.getStyle().set("border", "3px solid #9E9E9E");
        copyRecipe.setEnabled(false);

        removeRecipe.addThemeVariants(ButtonVariant.LUMO_LARGE, ButtonVariant.LUMO_ERROR);
        removeRecipe.getStyle().set("border", "3px solid #9E9E9E");
        removeRecipe.setEnabled(false);


    }

    private void configureGrids() {
        recipeGrid.setSizeFull();
        recipeGrid.setColumns("name", "cookingTime", "totalCalories");
        recipeGrid.setItems(recipeService.findAllRecipes());
        recipeGrid.getColumns().forEach(col -> col.setAutoWidth(true));
        recipeGrid.asSingleSelect().addValueChangeListener(event -> {
            findRecipe.setEnabled(true);
            editRecipe.setEnabled(true);
            copyRecipe.setEnabled(true);
            removeRecipe.setEnabled(true);
            recipeForm.setVisible(false);
            ingredientGrid.setVisible(true);
            recipeGrid.getSelectedItems().forEach(recipe -> ingredientGrid.setItems(recipe.getIngredients()));
        });

        ingredientGrid.setSizeFull();
        ingredientGrid.setColumns("name", "amount", "protein",
                "carbohydrates", "fat");
        ingredientGrid.addColumn(Ingredient::getCaloriesPer100Gr).setHeader("Calories/100g");
        ingredientGrid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private void configureButtonsBar() {
        findRecipe.setPlaceholder("Find recipe by keywords: ");
        findRecipe.setClearButtonVisible(true);
        findRecipe.setValueChangeMode(ValueChangeMode.EAGER);
        findRecipe.addValueChangeListener(event -> updateRecipeGrid());

        buttonsBar.setWidth("90%");
        buttonsBar.add(findRecipe, addRecipe, editRecipe, copyRecipe, removeRecipe, helpButton, aboutApp, showStats);
        buttonsBar.getStyle().set("border", "3px solid #4B9DFF");
    }

    private void configureInfoBar() {
        recipeForm.setSizeFull();
        recipeForm.setVisible(false);
        ingredientForm.setVisible(false);
        recipeSection.add(recipeGrid, recipeText);
        infoBar.setSizeFull();
        infoBar.add(recipeSection, ingredientGrid, recipeForm, ingredientForm);
        infoBar.getStyle().set("border", "3px solid #4B9DFF");
    }

    private void updateRecipeGrid() {
        recipeGrid.setItems(recipeService.findRecipeByName(findRecipe.getValue()));
    }

    public VerticalLayout getRecipeSection() {
        return recipeSection;
    }

    public IngredientForm getIngredientForm() {
        return ingredientForm;
    }

    public RecipeForm getRecipeForm() {
        return recipeForm;
    }

    public TextField getFindRecipe() {
        return findRecipe;
    }
}
