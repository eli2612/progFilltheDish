package home.home2;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static home.home2.Home.ps;

public class SearchController implements Initializable {

    private static final String LOGIN = "Login";
    private static final String RESULT = "Result";
    @FXML
    private TextField search;
    @FXML
    private Button primi;
    @FXML
    private Button secondi;
    @FXML
    private Button contorni;
    @FXML
    private Button antipasti;
    @FXML
    private Button dessert;
    @FXML
    private Pane darkSearch;
    @FXML
    private Button colazioni;
    @FXML
    private Button menuButton;
    @FXML
    private Pane menuSearch;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        darkSearch.setVisible(false);
        menuSearch.setVisible(false);
    }
    @FXML
    private void clickMenuButtonSearch() {
        if (menuSearch.isVisible()) {

            FadeTransition transition = new FadeTransition(Duration.seconds(0.5), darkSearch);
            transition.setFromValue(1);
            transition.setToValue(0);
            transition.play();

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), menuSearch);
            TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(0.5), menuButton);
            translateTransition1.setByX(-320);
            translateTransition2.setByX(-220);
            translateTransition1.play();
            translateTransition2.play();

            transition.setOnFinished(event -> {
                darkSearch.setVisible(false);
                menuSearch.setVisible(false);
            });

        } else {
            menuSearch.setVisible(true);
            darkSearch.setVisible(true);

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), darkSearch);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.play();

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), menuSearch);
            TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(0.5), menuButton);
            translateTransition1.setByX(320);
            translateTransition2.setByX(220);
            translateTransition1.play();
            translateTransition2.play();
        }
    }


    @FXML
    private void clickMenuLink3() throws IOException {
        General.changeScene(General.setSource(LOGIN));
    }

    @FXML
    private void clickMenuLink1() throws IOException {
        ps.setScreen("1");
        General.changeScene(General.setSource(RESULT));
    }
    @FXML
    private void clickMenuLink2() throws IOException {
        if (Boolean.TRUE.equals(General.getLoginState())) {
            General.changeScene(General.setSource("Insert"));
        } else {
            ps.add("Insert.fxml");
            General.changeScene(General.setSource(LOGIN));
        }
    }


    @FXML
    private void clickMenuLink5() throws IOException {
        General.changeScene(General.setSource("Review"));
    }
    @FXML
    private void clickMenuLink4OnMenu() throws IOException {
        General.changeScene(General.setSource("Subscribe"));
    }


    @FXML
    private void clickMenuLink7Fridge() throws IOException {
        if (Boolean.TRUE.equals(General.getLoginState())) {
            General.changeScene(General.setSource("Fridge"));
        } else {
            ps.add("Fridge.fxml");
            General.changeScene(General.setSource(LOGIN));
        }
    }

    @FXML
    public void clickPortata(MouseEvent event) throws IOException {
        PendentScreen ps = Home.getPS();
        Button  click ;
        click = (Button)event.getSource();
        switch (click.getId()) {
            case "primi" -> ps.setLabel(primi.getText());
            case "secondi" -> ps.setLabel(secondi.getText());
            case "contorni" -> ps.setLabel(contorni.getText());
            case "colazioni" -> ps.setLabel(colazioni.getText());
            case "dessert" -> ps.setLabel(dessert.getText());
            case "antipasti" -> ps.setLabel(antipasti.getText());
            default -> {
                //
            }
        }
        ps.setScreen("1");
        General.changeScene(General.setSource(RESULT));
    }
    @FXML
    private void clickIngredientsButton() throws IOException {
        General.changeScene(General.setSource("Ingredients"));
    }
    @FXML
    private void clickSearchButton() throws IOException {
        General.changeScene(General.setSource(RESULT));
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
    private void clickMenuLink6() throws IOException {
        PendentScreen ps5 ;
        if (Boolean.TRUE.equals(General.getLoginState())) {
            General.changeScene(General.setSource("Favourite"));
        } else {
            ps5 = Home.getPS();
            ps5.add("Favourite.fxml");

            General.changeScene(General.setSource(LOGIN));
        }
    }


}