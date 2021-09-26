package com.myrecipes.frontend.service.dummydata;

import com.myrecipes.frontend.domain.Ingredient;
import com.myrecipes.frontend.domain.Recipe;
import com.myrecipes.frontend.domain.Spice;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class DummyData {

    public Recipe getDummyRecipe() {

        Ingredient ingredient1 = new Ingredient(1, "ingr 1", 1, 11, 111, 12, 200);
        Ingredient ingredient2 = new Ingredient(2, "ingr 2", 1, 12, 222, 12, 200);
        Ingredient ingredient3 = new Ingredient(3, "ingr 3", 1, 13, 333, 12, 200);
        Ingredient ingredient4 = new Ingredient(4, "ingr 4", 1, 14, 444, 12, 200);
        Ingredient ingredient5 = new Ingredient(5, "ingr 5", 1, 15, 555, 12, 200);

        Spice spice1 = new Spice(1, "spice 1");
        Spice spice2 = new Spice(2, "spice 2");
        Spice spice3 = new Spice(3, "spice 3");
        Spice spice4 = new Spice(4, "spice 4");
        Spice spice5 = new Spice(5, "spice 5");

        Recipe recipe = new Recipe(1, "dummy recipe 1","dummy desc 1", 60);

        recipe.addIngredient(ingredient1);
        recipe.addIngredient(ingredient2);
        recipe.addIngredient(ingredient3);
        recipe.addIngredient(ingredient4);
        recipe.addIngredient(ingredient5);
        recipe.addSpice(spice1);
        recipe.addSpice(spice2);
        recipe.addSpice(spice3);
        recipe.addSpice(spice4);
        recipe.addSpice(spice5);

        return recipe;
    }

}
