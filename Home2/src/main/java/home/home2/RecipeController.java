package home.home2;

import home.home2.controller.CalculateRecipeController;
import home.home2.controller.FavouritesController;
import home.home2.beans.CalculateRecipeBean;
import home.home2.beans.FavouritesBean;
import home.home2.beans.IngredientBean;
import home.home2.model.exceptions.DuplicateRecipeException;
import home.home2.model.exceptions.ProvideLoginException;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static home.home2.Home.ps;

public class RecipeController implements Initializable {
    private static final String LOGIN = "Login";
    Boolean inFavourite;
    Image heart = new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\heart.png");
    Image check = new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\true.png");

    @FXML
    Button menuButton;
    @FXML
    Button homeButton;
    @FXML
    Button backButton;
    @FXML
    private Pane menu;
    @FXML
    private Pane dark;
    @FXML
    private ImageView favButton;

    @FXML
    private ImageView recipeImg;
    @FXML
    private Label recipeName;

    @FXML
    private Text recipeDescription;

    @FXML
    private VBox verticalBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menu.setVisible(false);
        dark.setVisible(false);
        favButton.setImage(heart);
        inFavourite = false;
        recipeDescription.setText(ps.getDescription());

        recipeName.setText(ps.getName());
        recipeImg.setImage(ps.getImage());



        CalculateRecipeBean recipeBean = new CalculateRecipeBean();
        CalculateRecipeController recipeController = new CalculateRecipeController();
        recipeBean.setName(recipeName.getText());
        List<IngredientBean> ingredientBeanList = recipeController.getIngredients(recipeBean);


        for (IngredientBean ingredientBean : ingredientBeanList) {
            FXMLLoader fxmlLoader = new FXMLLoader();

            try {
                fxmlLoader.setLocation(getClass().getResource("ingredient.fxml"));

                Pane anchorPane = fxmlLoader.load();

                IngredientController ingredientController = fxmlLoader.getController();
                ingredientController.setData(ingredientBean);

                verticalBox.getChildren().add(anchorPane);
                VBox.setMargin(anchorPane, new Insets(2));

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    @FXML
    private void clickMenuButton()  {
        if (menu.isVisible()) {

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), dark);
            fadeTransition.setToValue(0);
            fadeTransition.setFromValue(1);

            fadeTransition.play();
            fadeTransition.setOnFinished(event -> {
                menu.setVisible(false);
                dark.setVisible(false);
            });
            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), menu);
            TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(0.5), menuButton);
            translateTransition1.setByX(-320);
            translateTransition2.setByX(-220);
            translateTransition1.play();
            translateTransition2.play();



        } else {
            menu.setVisible(true);
            dark.setVisible(true);

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), dark);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.play();

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), menu);
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
    private void clickMenuLink1() throws IOException {
        General.changeScene(General.setSource("Result"));
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
    private void clickHomeButton() throws IOException {
        General.changeScene(General.setSource("Home"));
    }
    @FXML
    private void clickMenuLink3() throws IOException {
        General.changeScene(General.setSource(LOGIN));
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
        if (Boolean.TRUE.equals(General.getLoginState())) {
            General.changeScene(General.setSource("Favourite"));
        } else {
            ps.add("Favourite.fxml");
            General.changeScene(General.setSource(LOGIN));
        }
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
    private void clickFavButton() throws IOException {

        FavouritesBean favBean = new FavouritesBean();
        favBean.setRecipeName(recipeName.getText());
        FavouritesController favController;
        try{
            favController = new FavouritesController();

                if (Boolean.TRUE.equals(General.getLoginState())) {

                    favController.addToFavourites(favBean);

                }
            } catch (DuplicateRecipeException e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Attenzione, ricetta presente nella lista dei preferiti");
                alert.show();
            }catch(ProvideLoginException e1){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Attenzione, devi prima fare il login");
                alert.show();
            }finally {
                if(Boolean.FALSE.equals(General.getLoginState())){
                    ps.add("Recipe.fxml");
                    General.changeScene(General.setSource(LOGIN));
                }
        }

    }

    @FXML
    private void hoveredButton() {
        favButton.setScaleX(1.2);
        favButton.setScaleY(1.2);
    }
    @FXML
    private void releaseButton() {
        favButton.setScaleX(1);
        favButton.setScaleY(1);
    }


}