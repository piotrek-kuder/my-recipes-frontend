package com.myrecipes.frontend;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("/front")
@PageTitle("Recipes frontend")
public class MainView extends HorizontalLayout {

    private Button selectUser = new Button("SELECT USER");
    private Button addUser = new Button("ADD USER");
    private Text userInfo = new Text("aaaaaaaaaaaaaaaaaaaa");


    public MainView() {
        VerticalLayout userSection = new VerticalLayout();
        userSection.add(selectUser, addUser, userInfo);
        add(userSection);
    }
}
