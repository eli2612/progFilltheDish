package home.home2;

import home.home2.controller.FavouritesController;
import javafx.event.ActionEvent;
import home.home2.model.exceptions.ProvideLoginException;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import home.home2.beans.FavouritesBean;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.fxml.Initializable;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static home.home2.Home.ps;

public class FavouriteController implements Initializable {
    @FXML
    private Pane menuFav;
    @FXML
    private Pane darkFav;
    @FXML
    private Button menuButton;
    @FXML
    private GridPane grid;


    @FXML
    private void clickMenuButtonFav() {
        if (menuFav.isVisible()) {

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), darkFav);
            fadeTransition.setFromValue(1);
            fadeTransition.setToValue(0);
            fadeTransition.play();

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), menuFav);
            TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(0.5), menuButton);
            translateTransition1.setByX(-320);
            translateTransition2.setByX(-220);
            translateTransition1.play();
            translateTransition2.play();

            fadeTransition.setOnFinished(event -> {
                menuFav.setVisible(false);
                darkFav.setVisible(false);
            });

        } else {
            menuFav.setVisible(true);
            darkFav.setVisible(true);

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), darkFav);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.play();

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), menuFav);
            TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(0.5), menuButton);
            translateTransition1.setByX(320);
            translateTransition2.setByX(220);
            translateTransition1.play();
            translateTransition2.play();
        }
    }
    @FXML
    private void clickHomeButton() throws IOException {
        General.changeScene(General.setSource("Home"));
    }
    @FXML
    private void clickBackButton() throws IOException {
        General.setBackScene();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)  {
        menuFav.setVisible(false);
        darkFav.setVisible(false);
        int i;
        int column = 0;
        int row = 1;


        FavouritesController controller = null;

        List<FavouritesBean> beans = null;

        try {
            controller = new FavouritesController();
        } catch (ProvideLoginException e) {
            e.printStackTrace();
        }

        assert controller != null;
        beans = controller.showFavourites();

        try {
            for (i=0;i<beans.size();i++) {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("ListElement.fxml"));
                Pane pane = fxmlloader.load();

                ElementController elementController = fxmlloader.getController();
                elementController.setData(beans.get(i));

                grid.add(pane, column, row++);
                grid.setGridLinesVisible(false);
                GridPane.setMargin(pane, new Insets(5));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @FXML
    private void clickMenuLink1(ActionEvent event) throws IOException {
        ps.setScreen("1");
        General.changeScene(General.setSource("Result"));
    }

    @FXML
    private void clickMenuLink3(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Login"));
    }

    @FXML
    private void clickMenuLink2(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Insert"));
    }
    @FXML
    private void clickMenuLink5() throws IOException {
        General.changeScene(General.setSource("Review"));
    }
    @FXML
    private void clickMenuLink6()  {
        //
    }
    @FXML
    private void clickMenuLink4(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Subscribe"));
    }
    @FXML
    private void clickMenuLink7() throws IOException {
        General.changeScene(General.setSource("Fridge"));
    }




}
