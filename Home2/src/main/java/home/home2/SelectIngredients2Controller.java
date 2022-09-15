package home.home2;

import home.home2.controller.CalculateRecipeController;
import home.home2.controller.ManageFridgeController;
import home.home2.beans.CalculateRecipeBean;
import home.home2.beans.FridgeBean;
import home.home2.model.Ingredient;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class SelectIngredients2Controller implements Initializable {

    @FXML
    private VBox verticalBox;

    private static final String LOGIN = "Login2";

    private static List<CalculateRecipeBean> recipeBeans = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ManageFridgeController fridgeController = new ManageFridgeController();
        List<FridgeBean> fridgeBeans;
        fridgeBeans = fridgeController.showFridge();

        for (FridgeBean fridgeBean : fridgeBeans) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ElementFridgeSelection2.fxml"));
                Pane anchorPane = fxmlLoader.load();

                ElementSelection2Controller selection2Controller = fxmlLoader.getController();
                selection2Controller.setData(fridgeBean);

                verticalBox.getChildren().add(anchorPane);
                VBox.setMargin(anchorPane, new Insets(5));

            } catch (IOException e) {
                e.printStackTrace();

            }
        }


    }

    public List<CalculateRecipeBean> getRecipesBeans(){
        return recipeBeans;
    }


    public void clickRecipesButton() throws IOException {
        PendentScreen2 ps1;
        ps1 = Home2.getPS2();
        ps1.setScreen2("1");
        General2.changeScene(General2.setSource("Result2"));
    }
    public void clickLoginButton() throws IOException {
        General2.changeScene(General2.setSource(LOGIN));
    }
    public void clickAddButton() throws IOException {
        General2.changeScene(General2.setSource("Add2"));
    }
    public void clickRecipe() throws IOException, SQLException {
        PendentScreen2 ps2;
        ps2 = Home2.getPS2();
        ps2.setScreen2("1");
        ps2.setScreen2("3");
        ElementSelection2Controller elementController = new ElementSelection2Controller();

        CalculateRecipeController recipeController = new CalculateRecipeController();
        CalculateRecipeBean recipeBean = new CalculateRecipeBean();

        ObservableList<Ingredient> fridgeIngredients = elementController.getFridgeIngredients();

        recipeBean.setListIng(fridgeIngredients);

        for(CalculateRecipeBean i : recipeController.checkIngredients(recipeBean)){
            recipeBeans.add(i);
        }
        General2.changeScene(General2.setSource("Result2"));

    }

    public void clickSearchButton() throws IOException {
        General2.changeScene(General2.setSource("Search2"));
    }


    public void clickFavouriteButton() throws IOException {
        General2.changeScene(General2.setSource("Favourite2"));
    }


    public void clickReviewButton() throws IOException {
        General2.changeScene(General2.setSource("Review2"));
    }

    public void clickBackButton() {
        //
    }



    public void clickInsertIngredients() throws IOException {
        General2.changeScene(General2.setSource("Ingredients2"));
    }
    public void clickFridgeButton() throws IOException {
        General2.changeScene(General2.setSource("Fridge2"));
    }
    public void clickHomeButton() throws IOException {
        General2.changeScene(General2.setSource("Home2"));
    }

}
