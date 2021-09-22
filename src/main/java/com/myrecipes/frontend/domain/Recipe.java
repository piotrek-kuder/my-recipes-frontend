package com.myrecipes.frontend.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Recipe {

    private long id;
    private String name;
    private String description;
    private int cookingTime;
    private int totalCalories;
    private List<Ingredient> ingredients = new ArrayList<>();
    private List<Spice> spices = new ArrayList<>();

    public Recipe(long id, String name, String description, int cookingTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cookingTime = cookingTime;
        this.totalCalories = countTotalCalories();
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void addSpice(Spice spice) {
        spices.add(spice);
    }

    public String printSpices(List<Spice> spices) {

        String allSpices = "";

        for (Spice spice: spices) {
            allSpices = allSpices + spice.getName() + ", ";
        }
        return allSpices = allSpices.substring(0, allSpices.length() - 2);
    }

    public int countTotalCalories() {
        return 0;
    }

    public int getTotalProtein() {
        return 0;
    }

    public int getTotalCarbohydrates() {
        return 0;
    }

    public int getTotalFat() {
        return 0;
    }
}
