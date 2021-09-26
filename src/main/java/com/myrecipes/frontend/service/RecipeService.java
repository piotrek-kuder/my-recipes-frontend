package com.myrecipes.frontend.service;

import com.myrecipes.frontend.domain.Recipe;
import com.myrecipes.frontend.service.dummydata.DummyData;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeService {

    @Autowired
    private final DummyData dummyData;

    public Recipe getDummyData() {
        return dummyData.getDummyRecipe();
    }
}
