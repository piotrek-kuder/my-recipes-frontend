package com.myrecipes.frontend.domain;

import lombok.Getter;

import java.time.LocalDate;
import java.time.Period;

@Getter
public abstract class AbstractUser {

    private final long id;
    private final String name;
    private final String gender;
    private final int mass;
    private final int height;
    private final LocalDate birthDate;
    private int age;
    private int dailyCalories;
    
    protected CaloriesValidator caloriesValidator;

    public AbstractUser(long id, String name, String gender, int mass, int height, LocalDate birthDate, int age, int dailyCalories) {

        this.id = id;
        this.name = name;
        this.gender = gender;
        this.mass = mass;
        this.height = height;
        this.birthDate = birthDate;
        this.age = calculateAge(birthDate);
        this.dailyCalories = 2000;
    }

    private int calculateAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();

        if(birthDate != null) {
            return Period.between(birthDate, currentDate).getYears();
        }
        return 0;
    }


    public int validateCalories(int dailyCalories) {
        return caloriesValidator.suggestCalories(dailyCalories);
    }
    
    public void setChosenCaloriesValidator(CaloriesValidator caloriesValidator) {
        this.caloriesValidator = caloriesValidator;
    }
}
