package home.home2;

import home.home2.controller.FavouritesController;
import home.home2.beans.FavouritesBean;
import home.home2.model.exceptions.ProvideLoginException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;



public class Favourite2Controller implements Initializable {

    @FXML
    private  VBox verticalBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int i;

        List<FavouritesBean> favouritesBeans;

        FavouritesController favController = null;
        try {
            favController = new FavouritesController();
        } catch (ProvideLoginException e) {
            e.printStackTrace();
        }

        assert favController != null;
        favouritesBeans = favController.showFavourites();

        try {
            for (i=0;i<favouritesBeans.size();i++) {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("ListElement2.fxml"));
                Pane anchorPane = fxmlloader.load();

                ElementController2 elementController = fxmlloader.getController();
                elementController.setData1(favouritesBeans.get(i));

                verticalBox.getChildren().add(anchorPane);
                VBox.setMargin(anchorPane, new Insets(5));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void clickReviewButton() throws IOException {
        General2.changeScene(General2.setSource("Review2"));

    }
    public void clickRecipesButton() throws IOException {
        PendentScreen2 ps = Home2.getPS2();
        ps.setScreen2("1");
        General2.changeScene(General2.setSource("Result2"));
    }

    public  void clickFridgeButton() throws IOException {
        PendentScreen2 ps = Home2.getPS2();
        if (Boolean.TRUE.equals(General2.getLoginStateSView())) {
            General2.changeScene(General2.setSource("Fridge2"));
        } else {
            ps.add("Fridge2.fxml");
            General2.changeScene(General2.setSource("Login2"));
        }

    }

    public void clickFavouriteButton() {
        // No
    }

    public void clickLoginButton() throws IOException {
        General2.changeScene(General2.setSource("Login2"));

    }



    public void clickSearchButton() throws IOException {
        General2.changeScene(General2.setSource("Home2"));

    }
    public void clickAddButton() throws IOException {
        General2.changeScene(General2.setSource("Add2"));

    }


    public void clickBackButton() {
        //
    }

    public void clickInsertIngredients() throws IOException {
        General2.changeScene(General2.setSource("Ingredients2"));
    }
    public void clickHomeButton() throws IOException {
        General2.changeScene(General2.setSource("Home2"));

    }



}
