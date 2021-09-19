package com.myrecipes.frontend.domain;

public class NormalCalories implements CaloriesValidator{
    @Override
    public int suggestCalories(int dailyCalories) {
        return dailyCalories;
    }
}
