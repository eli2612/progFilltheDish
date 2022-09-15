package home.home2;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReviewController implements Initializable {
    private int vote;
    private String click;
    private Image star;
    private Image starfilled;

    @FXML
    private Label alert;
    @FXML
    private TextField email;
    @FXML
    private TextArea note;
    @FXML
    private ImageView star1;
    @FXML
    private Button menuButton;

    @FXML
    private ImageView star4;

    @FXML
    private ImageView star3;
    @FXML
    private ImageView star2;

    @FXML
    private ImageView star5;
    @FXML
    private Pane menuReview;
    @FXML
    private Pane darkReview;
    private static final String LOGIN = "Login";


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menuReview.setVisible(false);
        darkReview.setVisible(false);
        alert.setVisible(false);

        vote = 0;
        star = new Image("C:\\Users\\987229\\Desktop\\progettoUfficiale\\Home2\\src\\main\\resources\\home\\home2\\star.png");
        starfilled = new Image("C:\\Users\\987229\\Desktop\\progettoUfficiale\\Home2\\src\\main\\resources\\home\\home2\\starfilled.png");

        star1.setImage(star);
        star2.setImage(star);
        star3.setImage(star);
        star4.setImage(star);
        star5.setImage(star);

    }

    @FXML
    private void clickMenuLink1() throws IOException {
        PendentScreen ps3;
        ps3 = Home.getPS();
        ps3.setScreen("1");
        General.changeScene(General.setSource("Result"));
    }
    @FXML
    private void clickMenuButtonReview() {
        if (menuReview.isVisible()) {

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), darkReview);
            fadeTransition.setFromValue(1);
            fadeTransition.setToValue(0);
            fadeTransition.play();

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), menuReview);
            TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(0.5), menuButton);
            translateTransition1.setByX(-320);
            translateTransition2.setByX(-220);
            translateTransition1.play();
            translateTransition2.play();

            fadeTransition.setOnFinished(event -> {
                menuReview.setVisible(false);
                darkReview.setVisible(false);
            });

        } else {
            menuReview.setVisible(true);
            darkReview.setVisible(true);

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), darkReview);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.play();

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), menuReview);
            TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(0.5), menuButton);
            translateTransition1.setByX(320);
            translateTransition2.setByX(220);
            translateTransition1.play();
            translateTransition2.play();
        }
    }


    @FXML
    private void clickHomeButtonReview() throws IOException {
        General.changeScene(General.setSource("Home"));
    }
    @FXML
    private void clickBackButtonReview() throws IOException {
        General.setBackScene();
    }


    @FXML
    private void clickMenuLink2Review() throws IOException {
        PendentScreen ps4;
        ps4 = Home.getPS();
        if (Boolean.TRUE.equals(General.getLoginState())) {
            General.changeScene(General.setSource("Insert"));
        } else {
            ps4.add("Insert.fxml");
            General.changeScene(General.setSource(LOGIN));
        }
    }
    @FXML
    private void clickMenuLink3Review() throws IOException {
        General.changeScene(General.setSource(LOGIN));
    }
    @FXML
    private void clickMenuLink4Review() throws IOException {
        General.changeScene(General.setSource("Subscribe"));
    }
    @FXML
    private void clickMenuLink5() throws IOException {
        General.changeScene(General.setSource("Review"));
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
    @FXML
    private void clickMenuLink7() throws IOException {
        PendentScreen ps6;
        ps6 = Home.getPS();
        if (Boolean.TRUE.equals(General.getLoginState())) {
            General.changeScene(General.setSource("Fridge"));
        } else {
            ps6.add("Fridge.fxml");
            General.changeScene(General.setSource(LOGIN));
        }
    }

    @FXML
    private void clickSubmitButton() {
        String address = email.getText();
        String comment = note.getText();
        alert.setVisible(address.equals("") || comment.equals("") || vote == 0);

    }


    public void clickStarReview(MouseEvent event) {
        click = event.getPickResult().getIntersectedNode().getId();
        switch (click) {
            case "star1":
                star1.setImage(starfilled);
                vote = 1;
                break;
            case "star2":
                star2.setImage(starfilled);
                star1.setImage(starfilled);

                vote = 2;
                break;
            case "star3":
                star3.setImage(starfilled);
                star1.setImage(starfilled);
                star2.setImage(starfilled);
                vote = 3;
                break;
            case "star4":
                star1.setImage(starfilled);
                star2.setImage(starfilled);
                star4.setImage(starfilled);
                star3.setImage(starfilled);
                vote = 4;
                break;
            case "star5":
                star1.setImage(starfilled);
                star3.setImage(starfilled);
                star2.setImage(starfilled);
                star5.setImage(starfilled);
                star4.setImage(starfilled);
                vote = 5;
                break;
            default:
                break;
        }
    }
    public void hoverStarReview(MouseEvent event)  {
        click = event.getPickResult().getIntersectedNode().getId();
        switch (click) {
            case "star1":
                star1.setImage(starfilled);
                break;
            case "star2":
                star2.setImage(starfilled);
                star1.setImage(starfilled);
                break;
            case "star3":
                star2.setImage(starfilled);
                star1.setImage(starfilled);
                star3.setImage(starfilled);
                break;
            case "star4":
                star4.setImage(starfilled);
                star2.setImage(starfilled);
                star1.setImage(starfilled);
                star3.setImage(starfilled);
                break;
            case "star5":
                star5.setImage(starfilled);
                star4.setImage(starfilled);
                star2.setImage(starfilled);
                star1.setImage(starfilled);
                star3.setImage(starfilled);
                break;
            default:
                break;
        }
    }
    public void releaseStarReview()  {
        switch (vote) {
            case 0 -> {
                star3.setImage(star);
                star1.setImage(star);
                star2.setImage(star);
                star5.setImage(star);
                star4.setImage(star);
            }
            case 1 -> {
                star4.setImage(star);
                star3.setImage(star);
                star2.setImage(star);
                star5.setImage(star);
            }
            case 2 -> {
                star3.setImage(star);
                star5.setImage(star);
                star4.setImage(star);
            }
            case 3 -> {
                star5.setImage(star);
                star4.setImage(star);
            }
            case 4 -> star5.setImage(star);
            default -> {
            }
        }
    }


}