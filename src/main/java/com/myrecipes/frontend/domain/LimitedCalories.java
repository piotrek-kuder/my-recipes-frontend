package com.myrecipes.frontend.domain;

public class LimitedCalories implements CaloriesValidator{
    @Override
    public int suggestCalories(int dailyCalories) {
        return (int)(0.8 * dailyCalories);
    }
}
