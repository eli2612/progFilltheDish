package home.home2;


import home.home2.beans.CalculateRecipeBean;

import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class ItemsController {

    @FXML
    private ImageView recipeImage;
    @FXML
    private Label recipeName;
    @FXML
    private Label recipeDescription;

    CalculateRecipeBean recipe;


    public void clickRecipeImage() throws IOException {
         PendentScreen ps;
        ps = Home.getPS();

        ps.setName(recipeName.getText());
        ps.setImage(recipeImage.getImage());
        ps.setDescription(recipeDescription.getText());

        General.changeScene(General.setSource("Recipe"));
    }


    public void setData(CalculateRecipeBean recipe) {
        this.recipe = recipe;
        recipeName.setText(recipe.getName());
        recipeImage.setImage(recipe.getImage());
        recipeDescription.setText(recipe.getDescription());
    }


}
