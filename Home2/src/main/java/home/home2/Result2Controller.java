package home.home2;

import home.home2.controller.AllRecipesController;
import home.home2.beans.CalculateRecipeBean;
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

public class Result2Controller implements Initializable {

    private static final String LOGIN = "Login2";
    private static final String ITEM = "items2.fxml";

    @FXML
    private GridPane grid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        switch (ps.getScreen2()) {
            case "1" -> {
                AllRecipesController recipe = new AllRecipesController();
                List<CalculateRecipeBean> recipeBeans = new ArrayList<>();
                try {
                    recipeBeans = recipe.allRecipes();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                getAllRecipesDB(recipeBeans);
            }
            case "2" -> {
                InsertIngredients2Controller insertIng2Controller = new InsertIngredients2Controller();
                getInsertedIngredientsRecipes(insertIng2Controller);
            }
            case "3" -> {
                SelectIngredients2Controller select2Controller = new SelectIngredients2Controller();
                getSelectedIngredientRecipes(select2Controller);
            }
            default -> {
                //
            }
        }

    }

    private void getAllRecipesDB(List<CalculateRecipeBean> recipeBeans) {
        int column = 0;
        int row = 1;
        try {

            for (int j = 0; j < recipeBeans.size(); j++) {
                FXMLLoader fxmlLoader = new FXMLLoader();

                fxmlLoader.setLocation(getClass().getResource(ITEM));

                Pane anchorPane = fxmlLoader.load();

                Items2Controller item2Controller = fxmlLoader.getController();
                item2Controller.setData(recipeBeans.get(j));

                if (column == 2) {
                    column = 0;
                    row++;
                }
                grid.add(anchorPane, column++, row);

                setGridProperties(grid);
                GridPane.setMargin(anchorPane, new Insets(100));
                GridPane.setHalignment(anchorPane, HPos.LEFT);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getSelectedIngredientRecipes(SelectIngredients2Controller select2Controller) {
        int column = 0;
        int row = 1;
        try {
            for (int j = 0; j < select2Controller.getRecipesBeans().size(); j++) {
                FXMLLoader fxmlLoader = new FXMLLoader();

                fxmlLoader.setLocation(getClass().getResource(ITEM));

                Pane anchorPane = fxmlLoader.load();

                Items2Controller item2Controller = fxmlLoader.getController();
                item2Controller.setData(select2Controller.getRecipesBeans().get(j));

                if (column == 2) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row);

                setGridProperties(grid);
                GridPane.setMargin(anchorPane, new Insets(100));
                GridPane.setHalignment(anchorPane, HPos.LEFT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void getInsertedIngredientsRecipes(InsertIngredients2Controller insertIng2Controller) {
        int column = 0;
        int row = 1;
        try {
            for (int j = 0; j < insertIng2Controller.getRecipes().size(); j++) {
                FXMLLoader fxmlLoader = new FXMLLoader();

                fxmlLoader.setLocation(getClass().getResource(ITEM));

                Pane anchorPane = fxmlLoader.load();

                Items2Controller item2Controller = fxmlLoader.getController();
                item2Controller.setData(insertIng2Controller.getRecipes().get(j));

                if (column == 2) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row);

                setGridProperties(grid);
                GridPane.setMargin(anchorPane, new Insets(100));
                GridPane.setHalignment(anchorPane, HPos.LEFT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setGridProperties(GridPane grid) {
        // set grid width
        grid.setMaxWidth(Region.USE_COMPUTED_SIZE);
        grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
        grid.setMaxWidth(Region.USE_PREF_SIZE);

        // set grid height
        grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
        grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
        grid.setMaxHeight(Region.USE_PREF_SIZE);

        grid.setAlignment(Pos.CENTER);
        grid.setGridLinesVisible(false);
    }


    public void clickReviewButtonResult() throws IOException {
        General2.changeScene(General2.setSource("Review2"));

    }

    public void clickFridgeButtonResult() throws IOException {
        if (General2.getLoginStateSView()) {
            General2.changeScene(General2.setSource("Fridge2"));
        } else {
            ps.add("Fridge2.fxml");
            General2.changeScene(General2.setSource(LOGIN));
        }

    }

    public void clickFavouriteButtonResult() throws IOException {
        if (General2.getLoginStateSView()) {
            General2.changeScene(General2.setSource("Favourite2"));
        } else {
            ps.add("Favourite2.fxml");
            General2.changeScene(General2.setSource(LOGIN));
        }

    }

    public void clickLoginButtonResult() throws IOException {
        General2.changeScene(General2.setSource(LOGIN));

    }

    public void clickAddButtonResult() throws IOException {
        General2.changeScene(General2.setSource("Add2"));

    }

    public void clickSearchButtonResult() throws IOException {
        General2.changeScene(General2.setSource("Search2"));

    }

    public void clickHomeButton() throws IOException {
        General2.changeScene(General2.setSource("Home2"));
    }

    public void clickBackButton() {
        //
    }

    public void clickInsertIngredientsResult() throws IOException {
        General2.changeScene(General2.setSource("Ingredients2"));
    }


}
