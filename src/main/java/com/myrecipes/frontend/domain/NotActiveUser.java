package com.myrecipes.frontend.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class NotActiveUser extends AbstractUser {

    private Lifestyle lifestyle;
    private Set<Recipe> recipes;

    public NotActiveUser(long id, String name, String gender, int mass, int height, LocalDate birthDate, int age, int dailyCalories) {
        super(id, name, gender, mass, height, birthDate, age, dailyCalories);
        this.lifestyle = Lifestyle.NOT_ACTIVE;
        this.recipes = new HashSet<>();
        this.caloriesValidator = new LimitedCalories();
    }
}
