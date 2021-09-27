package com.myrecipes.frontend.view.components;

import com.myrecipes.frontend.domain.Ingredient;
import com.myrecipes.frontend.view.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.HasValueChangeMode;
import com.vaadin.flow.data.value.ValueChangeMode;

public class RecipeForm extends FormLayout {

    private MainView mainView;
    private TextField name = new TextField("Name");
    private TextField description = new TextField("Description");
    private TextField cookingTime = new TextField("Cooking Time");
    private TextField typeIngr = new TextField("Type ingredent name: ");
    private Label spicesList = new Label();
    private Button save = new Button("Save");
    private Button cancel = new Button("Cancel");
    private Button addIngredient = new Button("Add ingredient", new Icon(VaadinIcon.PLUS));
    private Button addSpice = new Button("Add spice", new Icon(VaadinIcon.PLUS));
    private Grid<Ingredient> presentIngr = new Grid<>(Ingredient.class);
    private Grid<Ingredient> suggestedIngr = new Grid<>(Ingredient.class);
    private HorizontalLayout buttonsLayout = new HorizontalLayout();
    private VerticalLayout gridsLayout = new VerticalLayout();
    private VerticalLayout formLayout = new VerticalLayout();

    public RecipeForm(MainView mainView) {
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

        addIngredient.getStyle().set("border", "3px solid #9E9E9E");
        addSpice.getStyle().set("border", "3px solid #9E9E9E");
    }

    private void configureButtonsLayout() {
        buttonsLayout.setWidth("150%");
        buttonsLayout.add(save, cancel, addIngredient, addSpice);
        buttonsLayout.getStyle().set("border", "3px solid #4B9DFF");
    }

    private void configureGrids() {
        presentIngr.setSizeFull();
        presentIngr.setColumns("name", "amount", "protein",
                "carbohydrates", "fat");
        presentIngr.addColumn(Ingredient::getCaloriesPer100Gr).setHeader("Calories/100g");
        presentIngr.getColumns().forEach(col -> col.setAutoWidth(true));

        suggestedIngr.setSizeFull();
        suggestedIngr.setColumns("name", "amount", "protein",
                "carbohydrates", "fat");
        suggestedIngr.addColumn(Ingredient::getCaloriesPer100Gr).setHeader("Calories/100g");
        suggestedIngr.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private void configureGridsLayout() {
        typeIngr.setPlaceholder(" ... type here ...");
        typeIngr.setClearButtonVisible(true);
        typeIngr.setValueChangeMode(ValueChangeMode.LAZY);
        typeIngr.setValueChangeTimeout(HasValueChangeMode.DEFAULT_CHANGE_TIMEOUT);
        spicesList.setTitle("Spices:");
        spicesList.setText("spice1, spice2, ...");
        gridsLayout.setSizeFull();
        gridsLayout.add(presentIngr, spicesList, typeIngr, suggestedIngr);
    }

    private void configureFormLayout() {
        name.setWidth("300px");
        description.setWidth("700px");
        cookingTime.setWidth("300px");
        formLayout.setSizeFull();
        formLayout.add(name, description, cookingTime, buttonsLayout, gridsLayout);
    }
}

