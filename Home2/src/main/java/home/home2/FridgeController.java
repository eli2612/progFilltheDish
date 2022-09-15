package home.home2;


import home.home2.controller.ManageFridgeController;
import home.home2.beans.FridgeBean;
import home.home2.model.exceptions.DuplicateIngredientException;
import home.home2.model.FridgeObserver;
import home.home2.model.FridgeSubject;
import javafx.fxml.FXML;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;

import java.util.List;
import java.util.ResourceBundle;

import static home.home2.Home.ps;

public class FridgeController implements Initializable, FridgeObserver {

    @FXML
    private VBox verticalBox;

    @FXML
    private TextField textField;

    @FXML
    private Pane menuFridge;
    @FXML
    private Pane darkFridge;
    @FXML
    private Button  menuButton;


    @Override
    public  void initialize(URL url, ResourceBundle resourceBundle) {
        menuFridge.setVisible(false);
        darkFridge.setVisible(false);

        FridgeSubject.attach(this);

        ManageFridgeController fridge = new ManageFridgeController();
        List<FridgeBean> fridgeBeans ;
        fridgeBeans = fridge.showFridge();


        for (FridgeBean fridgeBean : fridgeBeans) {
            FXMLLoader fxmlloader = new FXMLLoader();
            fxmlloader.setLocation(getClass().getResource("ElementFridge.fxml"));
            try {
                Pane anchorPane = fxmlloader.load();
                ElementController elementController = fxmlloader.getController();

                elementController.setData2(fridgeBean);

                verticalBox.getChildren().add(anchorPane);
                VBox.setMargin(anchorPane, new Insets(5));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void addToFridge() {


        if(!textField.getText().equals("")) {
            FridgeBean f = new FridgeBean();

            f.setIngredientName(textField.getText());

            ManageFridgeController fridge = new ManageFridgeController();

            if (!fridge.getImage(f)) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("*.jpg,*.png", "*.jpg", "*.png"));
                File file = fileChooser.showOpenDialog(null);
                if (file != null) {
                    InputStream inputStream = null;
                    String imagePath = file.getAbsolutePath();
                    try {
                        inputStream = new FileInputStream(imagePath);
                        f.setIngredientInputStream(new FileInputStream(imagePath));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    Image image = new Image(inputStream);
                    f.setIngredientImage(image);

                } else {
                    //
                }

            }

            try{
                fridge.addIngredient(f);
            } catch (DuplicateIngredientException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Attenzione, stai per inserire un ingrediente esistente");
                alert.show();
            }


            textField.setText("");
        }


    }



    public void clickBackButton() throws IOException {
        General.setBackScene();
    }
    @Override
    public void update(FridgeBean fridgebean) {

        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(getClass().getResource("ElementFridge.fxml"));

        try{
            Pane anchorPane = fxmlloader.load();

            ElementController elementController = fxmlloader.getController();
            elementController.setData2(fridgebean);

            verticalBox.getChildren().add(anchorPane);
            VBox.setMargin(anchorPane, new Insets(5));


        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void clickHomeButton() throws IOException {
        General.changeScene(General.setSource("Home"));
    }

    @FXML
    private void clickMenuLink1() throws IOException {
        ps.setScreen("1");
        General.changeScene(General.setSource("Result"));
    }
    @FXML
    private void clickMenuLink2() throws IOException {
        General.changeScene(General.setSource("Insert"));
    }
    @FXML
    private void clickMenuLink3() throws IOException {
        General.changeScene(General.setSource("Login"));
    }
    @FXML
    private void clickMenuLink4() throws IOException {
        General.changeScene(General.setSource("Subscribe"));
    }
    @FXML
    private void clickMenuLink5() throws IOException {
        General.changeScene(General.setSource("Review"));
    }
    @FXML
    private void clickMenuLink6() throws IOException {
        General.changeScene(General.setSource("Favourite"));
    }


    public void clickMenuButtonFridge() {
        if (menuFridge.isVisible()) {
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), darkFridge);
            fadeTransition.setFromValue(1);
            fadeTransition.setToValue(0);
            fadeTransition.play();

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), menuFridge);
            TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(0.5), menuButton);
            translateTransition1.setByX(-320);
            translateTransition2.setByX(-220);
            translateTransition1.play();
            translateTransition2.play();

            fadeTransition.setOnFinished(event -> {
                menuFridge.setVisible(false);
                darkFridge.setVisible(false);
            });

        } else {
            menuFridge.setVisible(true);
            darkFridge.setVisible(true);

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), darkFridge);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.play();

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), menuFridge);
            TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(0.5), menuButton);
            translateTransition1.setByX(320);
            translateTransition2.setByX(220);
            translateTransition1.play();
            translateTransition2.play();
        }
    }

}
