package com.myrecipes.frontend.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
public class Recipe {

    private long id;
    private String name;
    private String description;
    private int cookingTime;
    private int totalCalories;
    private List<Ingredient> ingredients;
    private List<String> spices;

    public Recipe(String name, String description, int cookingTime) {
        this.id = 0;
        this.name = name;
        this.description = description;
        this.cookingTime = cookingTime;
        this.totalCalories = 0;
        this.ingredients = new ArrayList<>();
        this.spices = new ArrayList<>();
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void addSpice(String spice) {
        spices.add(spice);
    }

    public String printSpices() {

        if(spices.size() > 0) {
            String allSpices = "Preferred spices: ";

            for (String spice: this.spices) {
                allSpices = allSpices + spice + ", ";
            }
            return allSpices = allSpices.substring(0, allSpices.length() - 2);
        } else {
            return "No spices specified";
        }
    }

    public String printDescription() {
        return "PRINT DESCRIPTION";
    }

    public int countTotalCalories() {
        return 1000;
    }

    public int getTotalProtein() {
        return 0;
    }  // todo stream po listach

    public int getTotalCarbohydrates() {
        return 0;
    }

    public int getTotalFat() {
        return 0;
    }
}
