package com.myrecipes.frontend;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("/front")
@PageTitle("Recipes frontend")
public class MainView extends VerticalLayout {

    public MainView() {

        setSizeFull();
    }
}
