package com.myrecipes.frontend.domain;

import lombok.Getter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
public class ActiveUser extends AbstractUser {

    private Lifestyle lifestyle;
    private Set<Recipe> recipes;

    public ActiveUser(long id, String name, String gender, int mass, int height, LocalDate birthDate, int age, int dailyCalories) {
        super(id, name, gender, mass, height, birthDate, age, dailyCalories);
        this.lifestyle = Lifestyle.ACTIVE;
        this.recipes = new HashSet<>();
        this.caloriesValidator = new ExtraCalories();
    }
}
