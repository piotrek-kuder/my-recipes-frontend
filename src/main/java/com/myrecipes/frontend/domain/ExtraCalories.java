package com.myrecipes.frontend.domain;

public class ExtraCalories implements CaloriesValidator{
    @Override
    public int suggestCalories(int dailyCalories) {
        return (int)(1.2 * dailyCalories);
    }
}
