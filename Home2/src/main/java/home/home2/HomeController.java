package home.home2;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;
import static home.home2.Home.ps;




public class HomeController implements Initializable {
    @FXML
    private Button menuButton;
    @FXML
    private Pane menuH;
    @FXML
    private Pane darkH;



    private static final String LOGINSTRING = "Login";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        menuH.setVisible(false);
        darkH.setVisible(false);

    }
    @FXML
    private void clickMenuButtonH() {
        if (menuH.isVisible()) {
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), darkH);
            fadeTransition.setFromValue(1);
            fadeTransition.setToValue(0);
            fadeTransition.play();

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), menuH);
            TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(0.5), menuButton);
            translateTransition1.setByX(-320);
            translateTransition2.setByX(-220);
            translateTransition1.play();
            translateTransition2.play();

            fadeTransition.setOnFinished(event -> {
                menuH.setVisible(false);
                darkH.setVisible(false);
            });

        } else {
            menuH.setVisible(true);
            darkH.setVisible(true);

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), darkH);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.play();

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), menuH);
            TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(0.5), menuButton);
            translateTransition1.setByX(320);
            translateTransition2.setByX(220);
            translateTransition1.play();
            translateTransition2.play();
        }
    }

    @FXML
    private void clickSearchButton() throws IOException {
        General.changeScene(General.setSource("Search"));
    }
    @FXML
    private void clickIngredientsButton() throws IOException {
        General.changeScene(General.setSource("Ingredients"));
    }


    @FXML
    private void clickMenuLink1H() throws IOException {
        ps.setScreen("1");
        General.changeScene(General.setSource("Result"));
    }
    @FXML
    private  void clickMenuLink2H() throws IOException {
        PendentScreen ps = Home.getPS();
        if (Boolean.TRUE.equals(General.getLoginState())) {
            General.changeScene(General.setSource("Insert"));
        } else {
            ps.add("Insert.fxml");
            General.changeScene(General.setSource(LOGINSTRING));
        }
    }
    @FXML
    private void clickMenuLink3H() throws IOException {
        General.changeScene(General.setSource(LOGINSTRING));
    }
    @FXML
    private void clickMenuLink4H() throws IOException {
        General.changeScene(General.setSource("Subscribe"));
    }
    @FXML
    private void clickMenuLink5H() throws IOException {
        General.changeScene(General.setSource("Review"));
    }
    @FXML
    private  void clickMenuLink6H() throws IOException {
        PendentScreen ps;
        if (Boolean.TRUE.equals(General.getLoginState())) {
            General.changeScene(General.setSource("Favourite"));
        } else {
            ps = Home.getPS();
            ps.add("Favourite.fxml");
            General.changeScene(General.setSource(LOGINSTRING));
        }
    }
    @FXML
    private void clickMenuLink7H() throws IOException {
        PendentScreen ps;
        if (Boolean.TRUE.equals(General.getLoginState())) {
            General.changeScene(General.setSource("Fridge"));
      } else {
            ps = Home.getPS();
            ps.add("Fridge.fxml");
            General.changeScene(General.setSource(LOGINSTRING));
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


}
