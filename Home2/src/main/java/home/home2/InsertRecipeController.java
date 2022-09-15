package home.home2;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InsertRecipeController implements Initializable {

    @FXML
    private Button menuButton;
    @FXML
    private Pane menuIns;
    @FXML
    private Pane darkIns;

    @FXML
    private ImageView dish1;
    @FXML
    private ImageView dish2;
    @FXML
    private ImageView dish3;
    @FXML
    private ImageView dish4;
    @FXML
    private ImageView dish5;
    @FXML
    private ImageView dish6;

    @FXML
    private ChoiceBox<String> portata;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        darkIns.setVisible(false);
        menuIns.setVisible(false);
        portata.getItems().addAll(" ","primo      ","secondo      ","colazione      ","antipasto      ","contorno      ","dessert      ");
        portata.setValue("Seleziona un ingrediente");
    }

    @FXML
    private void clickHomeButton() throws IOException {
        General.changeScene(General.setSource("Home"));
    }
    @FXML
    private void clickBackButton() throws IOException {
        General.setBackScene();
    }

    @FXML
    private void clickSubmitButton() {
        //
    }
    @FXML
    private void clickMenuButtonIns() {
        if (menuIns.isVisible()) {

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), darkIns);
            fadeTransition.setFromValue(1);
            fadeTransition.setToValue(0);
            fadeTransition.play();

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), menuIns);
            TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(0.5), menuButton);
            translateTransition1.setByX(-320);
            translateTransition2.setByX(-220);
            translateTransition1.play();
            translateTransition2.play();

            fadeTransition.setOnFinished(event -> {
                menuIns.setVisible(false);
                darkIns.setVisible(false);
            });

        } else {
            menuIns.setVisible(true);
            darkIns.setVisible(true);

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), darkIns);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.play();

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), menuIns);
            TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(0.5), menuButton);
            translateTransition1.setByX(320);
            translateTransition2.setByX(220);
            translateTransition1.play();
            translateTransition2.play();
        }
    }


    @FXML
    private void clickMenuLink1Ins() throws IOException {
        PendentScreen ps = Home.getPS();
        ps.setScreen("1");
        General.changeScene(General.setSource("Result"));
    }
    @FXML
    private void clickMenuLink2Ins() {
        //
    }
    @FXML
    private void clickMenuLink3Ins() throws IOException {
        General.changeScene(General.setSource("Login"));
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
    private void clickMenuLink6Ins() throws IOException {
        General.changeScene(General.setSource("Favourite"));
    }
    @FXML
    private void clickMenuLink7Ins() throws IOException {
        General.changeScene(General.setSource("Fridge"));
    }


}
