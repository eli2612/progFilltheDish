package home.home2;

import home.home2.controller.EnrollController;
import home.home2.beans.EnrollBean;
import home.home2.model.exceptions.FailedRegistrationException;
import home.home2.model.exceptions.InvalidSyntaxEmailException;
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

import static home.home2.Home.ps;

public class SubscribeController implements Initializable {

    private static final String LOGIN = "Login";


    @FXML
    private TextField name;
    @FXML
    private TextField lastname;
    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
    private TextField pwd;
    @FXML
    private TextField pwdRepeat;
    @FXML
    private Label pwdAlert1;
    @FXML
    private Label pwdAlert2;
    @FXML
    private Label pwdAlert3;
    @FXML
    private Label pwdAlert4;
    @FXML
    private Label alert;

    @FXML
    private Label alertUser;
    @FXML
    private Pane menu;

    @FXML
    private Pane dark;
    @FXML
    private Button menuButton;
    @FXML
    private Button subscribe;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pwdAlert1.setVisible(false);
        menu.setVisible(false);
        dark.setVisible(false);
        pwdAlert2.setVisible(false);
        pwdAlert3.setVisible(false);
        pwdAlert4.setVisible(false);
        alert.setVisible(false);
        alertUser.setVisible(false);



    }

    @FXML
    private void clickMenuButton()  {
        if (menu.isVisible()) {



            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), menu);
            TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(0.5), menuButton);
            translateTransition1.setByX(-320);
            translateTransition2.setByX(-220);
            translateTransition1.play();
            translateTransition2.play();

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), dark);
            fadeTransition.setFromValue(1);
            fadeTransition.setToValue(0);
            fadeTransition.play();

            fadeTransition.setOnFinished(event -> {
                menu.setVisible(false);
                dark.setVisible(false);
            });

        } else {
            menu.setVisible(true);
            dark.setVisible(true);

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), menu);
            TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(0.5), menuButton);
            translateTransition2.setByX(220);
            translateTransition1.setByX(320);
            translateTransition1.play();
            translateTransition2.play();

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), dark);
            fadeTransition.setToValue(1);
            fadeTransition.setFromValue(0);
            fadeTransition.play();


        }
    }



    @FXML
    private void clickBackButton() throws IOException {
        General.setBackScene();
    }




    @FXML
    private void clickHomeButton() throws IOException {
        General.changeScene(General.setSource("Home"));
    }

    @FXML
    private void clickMenuLink1() throws IOException {
        PendentScreen ps3;
        ps3 = Home.getPS();
        ps3.setScreen("1");
        General.changeScene(General.setSource("Result"));
    }
    @FXML
    private void clickMenuLink3() throws IOException {
        General.changeScene(General.setSource(LOGIN));
    }

    @FXML
    private void clickMenuLink5() throws IOException {
        General.changeScene(General.setSource("Review"));
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
    private void clickMenuLink4() throws IOException {
        General.changeScene(General.setSource("Subscribe"));
    }

    @FXML
    private void clickMenuLink7() throws IOException {
        if (Boolean.TRUE.equals(General.getLoginState())) {
            General.changeScene(General.setSource("Fridge"));
        } else {
            ps.add("Fridge.fxml");
            General.changeScene(General.setSource(LOGIN));
        }
    }

    @FXML
    private void clickLogin() throws IOException {
        General.changeScene(General.setSource(LOGIN));
    }


    @FXML
    private void clickSubscribe(ActionEvent event) throws IOException {

        EnrollBean eb = new EnrollBean();
        eb.setUsername(username.getText());
        eb.setName(name.getText());
        eb.setCognome(lastname.getText());
        eb.setEmail(email.getText());
        eb.setPassword(pwd.getText());

        EnrollController ec = new EnrollController();
        try {
            if (ec.addUser(eb)  && eb.getPassword().equals(pwdRepeat.getText())) {
                General.changeScene(General.setSource(LOGIN));
            } else {
               //
            }
        }catch (InvalidSyntaxEmailException e){
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setContentText("Inserisci un indirizzo mail valido");
            alert1.show();
        }catch (FailedRegistrationException e){
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setContentText("Registrazione fallita");
            alert2.show();
        }
        }
    @FXML
    private void clickMenuLink6() throws IOException {
        if (Boolean.TRUE.equals(General.getLoginState())) {
            General.changeScene(General.setSource("Favourite"));
        } else {
            ps.add("Favourite.fxml");

            General.changeScene(General.setSource(LOGIN));
        }
    }
}
