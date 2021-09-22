package com.myrecipes.frontend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Ingredient {

    private long id;
    private String name;
    private int amount;
    private int protein;
    private int carbohydrates;
    private int fat;
    private int caloriesPer100Gr;
}
