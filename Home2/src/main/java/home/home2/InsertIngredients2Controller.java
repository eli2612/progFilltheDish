package home.home2;

import home.home2.controller.CalculateRecipeController;
import home.home2.beans.CalculateRecipeBean;
import home.home2.model.Ingredient;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static home.home2.Home2.ps;

public class InsertIngredients2Controller implements Initializable {

    private static final String LOGIN = "Login2";

    @FXML
    private GridPane grid;

    private static DynamicCB2Controller choiceBox2Controller ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        int column = 0 ;
        int row  = 1;

        try {

            for(int i=0;i<22;i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("dynamicCB2.fxml"));

                Pane pane = fxmlLoader.load();
                getContr(fxmlLoader.getController());


                if (column == 2) {
                    column = 0;
                    row++;
                }

                grid.setMaxWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
                GridPane.setHalignment(pane, HPos.CENTER);
                grid.setMaxWidth(Region.USE_PREF_SIZE);
                // set grid height
                grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
                grid.setAlignment(Pos.CENTER);
                grid.setMaxHeight(Region.USE_PREF_SIZE);
                grid.add(pane, column++, row);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                GridPane.setMargin(pane, new Insets(50));


                grid.setGridLinesVisible(false);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void getContr(Object controller) {
        choiceBox2Controller = (DynamicCB2Controller) controller;
    }

    private static List<CalculateRecipeBean> recipeBeans2 = new ArrayList<>();

    public List<CalculateRecipeBean> getRecipes(){
        return recipeBeans2;
    }

    public void clickRecipe() throws IOException, SQLException {
        PendentScreen2 ps = Home2.getPS2();
        ps.setScreen2("2");

        ObservableList<Ingredient> ingredients;
        ingredients = choiceBox2Controller.getValues();

        CalculateRecipeBean recipeBean = new CalculateRecipeBean();
        recipeBean.setListIng(ingredients);

        CalculateRecipeController recipeController = new CalculateRecipeController();

        for(CalculateRecipeBean i : recipeController.checkIngredients(recipeBean)){
            recipeBeans2.add(i);
        }

        General2.changeScene(General2.setSource("Result2"));

    }

    public void clickSearchButton() throws IOException {
        General2.changeScene(General2.setSource("Search2"));
    }

    public void clickAddButton() throws IOException {
        General2.changeScene((General2.setSource("Add2")));
    }

    public void clickLoginButton() throws IOException {
        General2.changeScene((General2.setSource(LOGIN)));
    }

    public void clickFavouriteButton() throws IOException {
        PendentScreen2 ps = Home2.getPS2();
        if (General2.getLoginStateSView()) {
            General2.changeScene(General2.setSource("Favourite2"));
        } else {
            ps.add("Favourite2.fxml");
            General2.changeScene(General2.setSource(LOGIN));
        }    }

    public void clickFridgeButton() throws IOException {
        PendentScreen2 ps = Home2.getPS2();
        if (General2.getLoginStateSView()) {
            General2.changeScene(General2.setSource("Fridge2"));
        } else {
            ps.add("Fridge2.fxml");
            General2.changeScene(General2.setSource(LOGIN));
        }

    }

    public void clickReviewButton() throws IOException {
        General2.changeScene(General2.setSource("Review2"));
    }



    public void clickInsertIngredients() throws IOException {
       //
    }

    public void clickRecipesButton() throws IOException {
        PendentScreen2 ps = Home2.getPS2();
        ps.setScreen2("1");
        General2.changeScene(General2.setSource("Result2"));
    }




    public void clickHomeButton() throws IOException {
        General2.changeScene(General2.setSource("Home2"));
    }
    public void clickFridge() throws IOException {
        if (General2.getLoginStateSView()) {
            General2.changeScene(General2.setSource("SelectIngredients2"));
        } else {
            ps.add("SelectIngredients2.fxml");
            General2.changeScene(General2.setSource(LOGIN));
        }
    }
    public void clickBackButton() {
        //
    }
}
