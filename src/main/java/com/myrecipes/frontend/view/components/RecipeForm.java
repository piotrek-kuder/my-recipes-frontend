package com.myrecipes.frontend.view.components;

import com.myrecipes.frontend.domain.Ingredient;
import com.myrecipes.frontend.domain.Recipe;
import com.myrecipes.frontend.service.RecipeService;
import com.myrecipes.frontend.view.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class RecipeForm extends VerticalLayout {

    private RecipeService recipeService;

    private MainView mainView;
    private TextField name = new TextField("Name");
    private TextField description = new TextField("Description");
    private TextField cookingTime = new TextField("Cooking Time");
    private Label spicesList = new Label();
    private Button save = new Button("Save recipe");
    private Button cancel = new Button("Cancel");
    private Button removeIngredient = new Button("Remove ingredient", new Icon(VaadinIcon.MINUS));
    private Button addSpice = new Button("Add/remove spices", new Icon(VaadinIcon.PLUS));
    private Grid<Ingredient> presentIngr = new Grid<>(Ingredient.class);
    private HorizontalLayout buttonsLayout = new HorizontalLayout();
    private VerticalLayout gridsLayout = new VerticalLayout();
    private VerticalLayout formLayout = new VerticalLayout();
    private Binder<Recipe> recipeBinder = new Binder<>(Recipe.class);

    public RecipeForm(MainView mainView, RecipeService recipeService) {
        this.recipeService = recipeService;
        this.mainView = mainView;
        setSizeFull();
        configureButtons();
        configureButtonsLayout();
        configureGrids();
        configureGridsLayout();
        configureFormLayout();
        add(formLayout);
    }

    private void configureButtons() {
        save.addThemeVariants(ButtonVariant.LUMO_LARGE);
        save.getStyle().set("border", "3px solid #9E9E9E");

        cancel.addThemeVariants(ButtonVariant.LUMO_LARGE);
        cancel.getStyle().set("border", "3px solid #9E9E9E");
        cancel.addClickListener(click -> {
            mainView.getRecipeSection().setVisible(true);
            mainView.getFindRecipe().setEnabled(true);
            mainView.getRecipeForm().setVisible(false);
            mainView.getIngredientForm().setVisible(false);
        });
        removeIngredient.getStyle().set("border", "3px solid #9E9E9E");
        removeIngredient.setEnabled(false);
        addSpice.getStyle().set("border", "3px solid #9E9E9E");
        addSpice.addClickListener(click -> {
        });
    }

    private void configureButtonsLayout() {
        buttonsLayout.setWidth("100%");
        buttonsLayout.add(save, cancel, removeIngredient, addSpice);
        buttonsLayout.getStyle().set("border", "3px solid #4B9DFF");
    }

    private void configureGrids() {
        presentIngr.setSizeFull();
        presentIngr.setColumns("name", "amount", "protein",
                "carbohydrates", "fat");
        //presentIngr.setItems(recipeService.getDummyData().getIngredients()); todo
        presentIngr.addColumn(Ingredient::getCaloriesPer100Gr).setHeader("Calories/100g");
        presentIngr.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private void configureGridsLayout() {
        spicesList.setTitle("Spices:");
        spicesList.setText("spice1, spice2, ...");
        gridsLayout.setSizeFull();
        gridsLayout.add(presentIngr, spicesList);
    }

    private void configureFormLayout() {
        name.setWidth("300px");
        description.setWidth("700px");
        cookingTime.setWidth("300px");
        formLayout.setSizeFull();
        formLayout.add(name, description, cookingTime, gridsLayout, buttonsLayout);
    }
}

