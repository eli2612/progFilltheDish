package home.home2;

import home.home2.beans.CalculateRecipeBean;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class Items2Controller {

    @FXML
    private ImageView recipeImage;
    @FXML
    private Label recipeName;
    @FXML
    private Label recipeDescription;

    CalculateRecipeBean recipe;

    public void clickRecipeIm() throws IOException {
        PendentScreen2 ps;

        ps = Home2.getPS2();

        ps.setName(recipeName.getText());
        ps.setImage(recipeImage.getImage());
        ps.setDescription(recipeDescription.getText());

        General2.changeScene(General2.setSource("Recipe2"));
    }

    public void setData(CalculateRecipeBean recipe) {
        this.recipe = recipe;
        recipeName.setText(recipe.getName());
        recipeImage.setImage(recipe.getImage());
        recipeDescription.setText(recipe.getDescription());
    }
}
