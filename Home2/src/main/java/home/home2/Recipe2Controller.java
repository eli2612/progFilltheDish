package home.home2;

import home.home2.controller.CalculateRecipeController;
import home.home2.beans.CalculateRecipeBean;
import home.home2.beans.IngredientBean;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static home.home2.Home2.ps;

public class Recipe2Controller implements Initializable {

    private static final String LOGIN = "Login2";

    @FXML
    private Text recipeDescription;

    @FXML
    private Label recipeName;

    @FXML
    private ImageView recipeImg;

    @FXML
    private VBox verticalBox;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        recipeName.setText(ps.getName());
        recipeImg.setImage(ps.getImage());
        recipeDescription.setText(ps.getDescription());


        CalculateRecipeBean recipeBean = new CalculateRecipeBean();
        recipeBean.setName(recipeName.getText());


        CalculateRecipeController recipeController = new CalculateRecipeController();
        List<IngredientBean> ingredientBeanList = recipeController.getIngredients(recipeBean);

        for (IngredientBean ingredientBean : ingredientBeanList) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ingredient.fxml"));

                Pane anchorPane = fxmlLoader.load();

                IngredientController ingredientController = fxmlLoader.getController();
                ingredientController.setData(ingredientBean);

                verticalBox.getChildren().add(anchorPane);
                VBox.setMargin(anchorPane, new Insets(2));

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public void clickHomeButton() throws IOException {
        General2.changeScene(General2.setSource("Home2"));
    }

    public void clickSearchButton() throws IOException {
        General2.changeScene(General2.setSource("Search2"));

    }
    public void clickAddButton() throws IOException {
        General2.changeScene(General2.setSource("Add2"));

    }
    public void clickLoginButton() throws IOException {
        General2.changeScene(General2.setSource(LOGIN));

    }
    public void clickFavouriteButton() throws IOException {
        if (Boolean.TRUE.equals(General2.getLoginStateSView())) {
            General2.changeScene(General2.setSource("Favourite2"));
        } else {
            ps.add("Favourite2.fxml");
            General2.changeScene(General2.setSource(LOGIN));
        }      }
    public void clickReviewButton() throws IOException {
        General2.changeScene(General2.setSource("Review2"));
    }

    public void clickFridgeButton() throws IOException {
        if (Boolean.TRUE.equals(General2.getLoginStateSView())) {
            General2.changeScene(General2.setSource("Fridge2"));
        } else {
            ps.add("Fridge2.fxml");
            General2.changeScene(General2.setSource(LOGIN));
        }
    }

    public void clickInsertIngredients() throws IOException {
        General2.changeScene(General2.setSource("Ingredients2"));
    }

    public void clickRecipesButton() throws IOException {
        ps.setScreen2("1");
        General2.changeScene(General2.setSource("Result2"));
    }

    public void clickBackButton() {
        //
    }


}
