package home.home2;

import home.home2.controller.AllRecipesController;
import home.home2.beans.CalculateRecipeBean;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

import static home.home2.Home.ps;

public class ResultController implements Initializable {

    private static final String LOGIN = "Login";
    private static final String ITEM = "items.fxml";
    @FXML
    GridPane grid;
    @FXML
    Button homeButton;
    @FXML
    Button menuButton;
    @FXML
    Button backButton;
    @FXML
    private Pane menuResult;
    @FXML
    private Pane darkResult;

    @FXML
    Label category;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        darkResult.setVisible(false);
        menuResult.setVisible(false);


        switch (ps.getScreen()) {
            case "1" -> {
                AllRecipesController recipe = new AllRecipesController();
                List<CalculateRecipeBean> recipeBeans = new ArrayList<>();
                try {
                    recipeBeans = recipe.allRecipes();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                getAllRecipesDBFInt(recipeBeans);
            }
            case "2" -> {
                InsertIngredientsController insertIngController = new InsertIngredientsController();
                getInsertedIngredientsRecipes(insertIngController);
            }
            case "3" -> {
                SelectIngredientsController selectController = new SelectIngredientsController();
                getSelectedIngredientRecipes(selectController);
            }
            default -> {
                //
            }
        }

    }

    private void getAllRecipesDBFInt(List<CalculateRecipeBean> recipeBeans) {
        int column = 0;
        int row = 1;
        try {

            for (CalculateRecipeBean recipeBean : recipeBeans) {
                FXMLLoader fxmlLoader = new FXMLLoader();

                fxmlLoader.setLocation(getClass().getResource(ITEM));

                Pane anchorPane = fxmlLoader.load();

                ItemsController itemController = fxmlLoader.getController();
                itemController.setData(recipeBean);

                if (column == 2) {
                    column = 0;
                    row++;
                }
                grid.add(anchorPane, column++, row);

                setGridPropertiesFInt(grid);
                GridPane.setMargin(anchorPane, new Insets(100));
                GridPane.setHalignment(anchorPane, HPos.LEFT);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getSelectedIngredientRecipes(SelectIngredientsController selectController) {
        int column = 0;
        int row = 1;
        try {
            for (int j = 0; j < selectController.getRecipesBeans().size(); j++) {
                FXMLLoader fxmlLoader = new FXMLLoader();

                fxmlLoader.setLocation(getClass().getResource(ITEM));

                Pane anchorPane = fxmlLoader.load();

                ItemsController itemController = fxmlLoader.getController();
                itemController.setData(selectController.getRecipesBeans().get(j));

                if (column == 2) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row);

                setGridPropertiesFInt(grid);
                GridPane.setMargin(anchorPane, new Insets(100));
                GridPane.setHalignment(anchorPane, HPos.LEFT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void getInsertedIngredientsRecipes(InsertIngredientsController insertIngController) {
        int row = 1;
        int column = 0;

        try {
            for (int j = 0; j < insertIngController.getRecipes().size(); j++) {
                FXMLLoader fxmlLoader = new FXMLLoader();

                fxmlLoader.setLocation(getClass().getResource(ITEM));

                Pane anchorPane = fxmlLoader.load();

                ItemsController itemController = fxmlLoader.getController();
                itemController.setData(insertIngController.getRecipes().get(j));

                if (column == 2) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row);

                setGridPropertiesFInt(grid);
                GridPane.setMargin(anchorPane, new Insets(100));
                GridPane.setHalignment(anchorPane, HPos.LEFT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setGridPropertiesFInt(GridPane grid) {
        grid.setMaxWidth(Region.USE_COMPUTED_SIZE);
        grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
        grid.setMaxHeight(Region.USE_PREF_SIZE);
        grid.setMaxWidth(Region.USE_PREF_SIZE);

        grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
        grid.setPrefWidth(Region.USE_COMPUTED_SIZE);


        grid.setAlignment(Pos.CENTER);
        grid.setGridLinesVisible(false);
    }


    @FXML
    private void clickHomeButton() throws IOException {
        General.changeScene(General.setSource("Home"));
    }


    @FXML
    private void clickMenuButtonResult()  {
        if (menuResult.isVisible()) {

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), darkResult);
            fadeTransition.setFromValue(1);
            fadeTransition.setToValue(0);
            fadeTransition.play();

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), menuResult);
            TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(0.5), menuButton);
            translateTransition1.setByX(-320);
            translateTransition2.setByX(-220);
            translateTransition1.play();
            translateTransition2.play();

            fadeTransition.setOnFinished(event -> {
                menuResult.setVisible(false);
                darkResult.setVisible(false);
            });

        } else {
            menuResult.setVisible(true);
            darkResult.setVisible(true);

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), darkResult);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.play();

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), menuResult);
            TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(0.5), menuButton);
            translateTransition1.setByX(320);
            translateTransition2.setByX(220);
            translateTransition1.play();
            translateTransition2.play();
        }
    }

    @FXML
    private void clickBackButton() throws IOException {
        General.setBackScene();
    }




    @FXML
    private void clickMenuLink1Result(){
        //
    }
    @FXML
    private void clickMenuLink2Result() throws IOException {
        if (Boolean.TRUE.equals(General.getLoginState())) {
            General.changeScene(General.setSource("Insert"));
        } else {
            ps.add("Insert.fxml");
            General.changeScene(General.setSource(LOGIN));
        }
    }
    @FXML
    private void clickMenuLink3Result() throws IOException {
        General.changeScene(General.setSource(LOGIN));
    }
    @FXML
    private void clickMenuLink4Result() throws IOException {
        General.changeScene(General.setSource("Subscribe"));
    }
    @FXML
    private void clickMenuLink5Result() throws IOException {
        General.changeScene(General.setSource("Review"));
    }
    @FXML
    private void clickMenuLink6Result() throws IOException {
        if (Boolean.TRUE.equals(General.getLoginState())) {
            General.changeScene(General.setSource("Favourite"));
        } else {
            ps.add("Favourite.fxml");
            General.changeScene(General.setSource(LOGIN));
        }
    }
    @FXML
    private void clickMenuLink7Result() throws IOException {
        if (Boolean.TRUE.equals(General.getLoginState())){
            General.changeScene(General.setSource("Fridge"));
        } else {
            ps.add("Fridge.fxml");
            General.changeScene(General.setSource(LOGIN));
        }
    }

}


