package home.home2;

import home.home2.beans.LoginBean;
import home.home2.model.exceptions.LoginFailedException;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private static final String LOGIN = "Login";

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label alert;
    @FXML
    private Button menuButton;
    @FXML
    private Pane menuLog;
    @FXML
    private Pane darkLog;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menuLog.setVisible(false);
        darkLog.setVisible(false);
        alert.setVisible(false);

    }



    @FXML
    private void clickHomeButton() throws IOException {
        PendentScreen ps = Home.getPS();
        ps.clear();
        General.changeScene(General.setSource("Home"));
    }

    @FXML
    private void clickBackButton() throws IOException {
        PendentScreen ps = Home.getPS();
        ps.clear();
        General.setBackScene();
    }


    @FXML
    private void clickLoginButton() throws IOException {
        PendentScreen ps = Home.getPS();

        General.setloginState(true);


        LoginBean lb = new LoginBean();
        lb.setUsername(username.getText());
        lb.setPassword(password.getText());

        home.home2.controller.LoginController lc = new home.home2.controller.LoginController();
        try{
            if (!lc.login(lb)) {
                alert.setVisible(true);
            }
            else{
                if (Boolean.TRUE.equals(ps.isNull())) {
                    General.changeScene(General.setSource("Home"));
                } else {
                    General.changeScene(ps.get());
                }

            }
        }catch(LoginFailedException e){
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setContentText("Account non registrato ! Creane uno prima di accedere al sistema");
            alert1.show();
        }finally {
            username.setText("");
            password.setText("");
        }


    }

    @FXML
    private void clickSubscribe() throws IOException {
        General.changeScene(General.setSource("Subscribe"));
    }
    @FXML
    private void clickMenuButtonLog() {
        if (menuLog.isVisible()) {

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), darkLog);
            fadeTransition.setFromValue(1);
            fadeTransition.setToValue(0);
            fadeTransition.play();

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), menuLog);
            TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(0.5), menuButton);
            translateTransition1.setByX(-320);
            translateTransition2.setByX(-220);
            translateTransition1.play();
            translateTransition2.play();

            fadeTransition.setOnFinished(event -> {
                menuLog.setVisible(false);
                darkLog.setVisible(false);
            });

        } else {
            menuLog.setVisible(true);
            darkLog.setVisible(true);

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), darkLog);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.play();

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), menuLog);
            TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(0.5), menuButton);
            translateTransition1.setByX(320);
            translateTransition2.setByX(220);
            translateTransition1.play();
            translateTransition2.play();
        }
    }


    @FXML
    private void clickMenuLink1Log() throws IOException {
        PendentScreen ps = Home.getPS();
        ps.clear();
        ps.setScreen("1");
        General.changeScene(General.setSource("Result"));
    }

    @FXML
    private void clickMenuLink2Log() throws IOException {
        PendentScreen ps = Home.getPS();
        if (Boolean.TRUE.equals(General.getLoginState())) {
            General.changeScene(General.setSource("Insert"));
        } else {
            ps.add("Insert.fxml");
            General.changeScene(General.setSource(LOGIN));
        }
    }

    @FXML
    private void clickMenuLink3Log() {
        // niente
    }

    @FXML
    private void clickMenuLink4Log() throws IOException {
        General.changeScene(General.setSource("Subscribe"));
    }

    @FXML
    private void clickMenuLink5Log() throws IOException {
        PendentScreen ps = Home.getPS();
        ps.clear();
        General.changeScene(General.setSource("Review"));
    }

    @FXML
    private void clickMenuLink6Log() throws IOException {
        PendentScreen ps = Home.getPS();
        if (Boolean.TRUE.equals(General.getLoginState())) {
            General.changeScene(General.setSource("Favourite"));
        } else {
            ps.add("Favourite.fxml");
            General.changeScene(General.setSource(LOGIN));
        }
    }

    @FXML
    private void clickMenuLink7Log(ActionEvent event) throws IOException {
        PendentScreen ps = Home.getPS();
        if (Boolean.TRUE.equals(General.getLoginState())) {
            General.changeScene(General.setSource("Fridge"));
        } else {
            ps.add("Fridge.fxml");
            General.changeScene(General.setSource(LOGIN));
        }
    }


}