package home.home2;

import home.home2.controller.CalculateRecipeController;
import home.home2.beans.CalculateRecipeBean;
import home.home2.model.Ingredient;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class InsertIngredientsController implements Initializable {

    @FXML
    private GridPane grid;


    private static DynamicCBController choiceBoxController ;


    private static final String LOGIN = "Login";

    @FXML
    private Button  menuButton;

    @FXML
    private Pane menuIn;
    @FXML
    private Pane darkIn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        int row  = 1;
        menuIn.setVisible(false);
        darkIn.setVisible(false);

        int column = 0 ;

        try {

            for(int i=0;i<22;i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("dynamicCB.fxml"));


                if (column == 2) {
                    column = 0;
                    row++;
                }
                Pane pane = fxmlLoader.load();
                getContr(fxmlLoader.getController());

                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                grid.setMaxHeight(Region.USE_PREF_SIZE);
                grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
                grid.add(pane, column++, row);
                GridPane.setMargin(pane, new Insets(50));
                grid.setAlignment(Pos.CENTER);
                GridPane.setHalignment(pane, HPos.CENTER);
                grid.setGridLinesVisible(false);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getContr(Object controller) {
        choiceBoxController = (DynamicCBController) controller;
    }

    @FXML
    private void clickHomeButton() throws IOException {
        General.changeScene(General.setSource("Home"));
    }
    @FXML
    private void clickBackButton() throws IOException {
        General.setBackScene();
    }

    private static List<CalculateRecipeBean> recipeBeans = new ArrayList<>() ;

    public  List<CalculateRecipeBean> getRecipes(){
        return recipeBeans;
    }


    @FXML
    private void clickRecipeButton() throws IOException {
        PendentScreen ps1;
        ps1 = Home.getPS();

        ps1.setScreen("2");
             // no
        ObservableList<Ingredient> ingredients = choiceBoxController.getValues();

        CalculateRecipeBean recipeBean = new CalculateRecipeBean();
        recipeBean.setListIng(ingredients);

        CalculateRecipeController recipeController = new CalculateRecipeController();
        try{
            for(CalculateRecipeBean i : recipeController.checkIngredients(recipeBean)){
                recipeBeans.add(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        General.changeScene(General.setSource("Result"));

    }




    @FXML
    private void clickFridgeButton() throws IOException {
        PendentScreen ps2;
        ps2 = Home.getPS();
        if (Boolean.TRUE.equals(General.getLoginState())) {
            General.changeScene(General.setSource("SelectIngredients"));
        } else {
            ps2.add("SelectIngredients.fxml");
            General.changeScene(General.setSource(LOGIN));
        }
    }



    @FXML
    private void clickMenuLink1() throws IOException {
        PendentScreen ps3;
        ps3 = Home.getPS();
        ps3.setScreen("1");
        General.changeScene(General.setSource("Result"));
    }
    @FXML
    private void clickMenuLink2() throws IOException {
        PendentScreen ps4;
        ps4 = Home.getPS();
        if (Boolean.TRUE.equals(General.getLoginState())) {
            General.changeScene(General.setSource("Insert"));
        } else {
            ps4.add("Insert.fxml");
            General.changeScene(General.setSource(LOGIN));
        }
    }
    @FXML
    private void clickMenuLink3Ins() throws IOException {
        General.changeScene(General.setSource(LOGIN));
    }
    @FXML
    private void clickMenuLink4Ins() throws IOException {
        General.changeScene(General.setSource("Subscribe"));
    }
    @FXML
    private void clickMenuLink5Ins() throws IOException {
        General.changeScene(General.setSource("Review"));
    }
    @FXML
    private void clickMenuLink6() throws IOException {
        PendentScreen ps1 ;
        if (Boolean.TRUE.equals(General.getLoginState())) {
            General.changeScene(General.setSource("Favourite"));
        } else {
            ps1 = Home.getPS();
            ps1.add("Favourite.fxml");

            General.changeScene(General.setSource(LOGIN));
        }
    }
    @FXML
    private void clickMenuLink7() throws IOException {
        PendentScreen ps5;
        ps5 = Home.getPS();
        if (Boolean.TRUE.equals(General.getLoginState())) {
            General.changeScene(General.setSource("Fridge"));
        } else {
            ps5.add("Fridge.fxml");
            General.changeScene(General.setSource(LOGIN));
        }
    }
    @FXML
    private void clickMenuLink8() throws IOException {
        General.changeScene(General.setSource("Home2"));
    }


    @FXML
    private void clickMenuButton(){
        if (Boolean.TRUE.equals(menuIn.isVisible())) {

            TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.5), menuButton);

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), menuIn);

            translateTransition1.setByX(-320);
            translateTransition.setByX(-220);
            translateTransition1.play();
            translateTransition.play();

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), darkIn);
            fadeTransition.setFromValue(1);
            fadeTransition.setToValue(0);
            fadeTransition.play();

            fadeTransition.setOnFinished(event -> {
                menuIn.setVisible(false);
                darkIn.setVisible(false);
            });

        } else {
            darkIn.setVisible(true);
            menuIn.setVisible(true);


            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), darkIn);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.play();

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), menuIn);
            TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(0.5), menuButton);
            translateTransition1.setByX(320);
            translateTransition2.setByX(220);
            translateTransition1.play();
            translateTransition2.play();
        }
    }


}