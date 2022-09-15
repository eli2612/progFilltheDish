package home.home2;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static home.home2.Home2.ps;


public class Review2Controller implements Initializable {

    private static final String LOGIN = "Login2";
    @FXML
    private ImageView star1;
    @FXML
    private ImageView star2;
    @FXML
    private ImageView star3;
    @FXML
    private ImageView star4;
    @FXML
    private ImageView star5;


    private static int vote=0;

    private final Image star = new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\star.png");
    private final Image starfilled = new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\starfilled.png");

    private String click;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        star1.setImage(star);
        star2.setImage(star);
        star3.setImage(star);
        star4.setImage(star);
        star5.setImage(star);
    }

    public void clickStar(MouseEvent event)  {
        click = event.getPickResult().getIntersectedNode().getId();
        switch (click) {
            case "star1" -> {
                star1.setImage(starfilled);
                vote = 1;
            }
            case "star2" -> {
                star1.setImage(starfilled);
                star2.setImage(starfilled);
                vote = 2;
            }
            case "star3" -> {
                star1.setImage(starfilled);
                star2.setImage(starfilled);
                star3.setImage(starfilled);
                vote = 3;
            }
            case "star4" -> {
                star1.setImage(starfilled);
                star2.setImage(starfilled);
                star3.setImage(starfilled);
                star4.setImage(starfilled);
                vote = 4;
            }
            case "star5" -> {
                star1.setImage(starfilled);
                star2.setImage(starfilled);
                star3.setImage(starfilled);
                star4.setImage(starfilled);
                star5.setImage(starfilled);
                vote = 5;
            }
            default -> {
                //
            }
        }
    }
    public void hoverStar(MouseEvent event) {
        click = event.getPickResult().getIntersectedNode().getId();
        switch (click) {
            case "star1":
                star1.setImage(starfilled);
                break;
            case "star2":
                star1.setImage(starfilled);
                star2.setImage(starfilled);
                break;
            case "star3":
                star1.setImage(starfilled);
                star2.setImage(starfilled);
                star3.setImage(starfilled);
                break;
            case "star4":
                star1.setImage(starfilled);
                star2.setImage(starfilled);
                star3.setImage(starfilled);
                star4.setImage(starfilled);
                break;
            case "star5":
                star1.setImage(starfilled);
                star2.setImage(starfilled);
                star3.setImage(starfilled);
                star4.setImage(starfilled);
                star5.setImage(starfilled);
                break;
            default:
                break;
        }
    }
    public void releaseStar()  {
        switch (vote) {
            case 0:
                star1.setImage(star);
                star2.setImage(star);
                star3.setImage(star);
                star4.setImage(star);
                star5.setImage(star);
                break;
            case 1:
                star2.setImage(star);
                star3.setImage(star);
                star4.setImage(star);
                star5.setImage(star);
                break;
            case 2:
                star3.setImage(star);
                star4.setImage(star);
                star5.setImage(star);
                break;
            case 3:
                star4.setImage(star);
                star5.setImage(star);
                break;
            case 4:
                star5.setImage(star);
                break;
            default:
                break;
        }
    }

    public void clickSubmit() {
        //
    }


    public void clickReviewButtonR2() throws IOException {
        General2.changeScene(General2.setSource("Review2"));

    }

    public void clickFridgeButtonR2() throws IOException {
        if (General2.getLoginStateSView()) {
            General2.changeScene(General2.setSource("Fridge2"));
        } else {
            ps.add("Fridge2.fxml");
            General2.changeScene(General2.setSource(LOGIN));
        }
    }

    public void clickFavouriteButtonR2() throws IOException {
        if (General2.getLoginStateSView()) {
            General2.changeScene(General2.setSource("Favourite2"));
        } else {
            ps.add("Favourite2.fxml");
            General2.changeScene(General2.setSource(LOGIN));
        }
    }

    public void clickLoginButtonR2() throws IOException {
        General2.changeScene(General2.setSource(LOGIN));

    }

    public void clickAddButtonR2() throws IOException {
        General2.changeScene(General2.setSource("Add2"));

    }

    public void clickSearchButton() throws IOException {
        General2.changeScene(General2.setSource("Search2"));

    }

    public void clickHomeButton() throws IOException {
        General2.changeScene(General2.setSource("Home2"));

    }

    public void clickBackButton() {
        //
    }

    public void clickInsertIngredients() throws IOException {
        General2.changeScene(General2.setSource("Ingredients2"));
    }

    public void clickRecipesButtonR2() throws IOException {
        ps.setScreen2("1");
        General2.changeScene(General2.setSource("Result2"));
    }
}
