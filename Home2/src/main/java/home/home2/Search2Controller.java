package home.home2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Search2Controller implements Initializable {
    Boolean[] portata = new Boolean[6];
    @FXML
    private ImageView primi;
    @FXML
    private ImageView secondi;
    @FXML
    private ImageView contorni;
    @FXML
    private ImageView colazioni;
    @FXML
    private ImageView dessert;
    @FXML
    private ImageView antipasti;


    private PendentScreen2 ps;

    public static final String LOGIN = "Login2";

    static final String IMAGESRC1 = "C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\sfondo_home2.png";
    static final String IMAGESRC2 = "C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\selectClick.png";
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int i;

        ps = Home2.getPS2();

        for (i=0;i<6;i++) {
            portata[i] = false;
        }
        primi.setImage(new Image(IMAGESRC1));
        primi.setScaleX(0.5);
        primi.setScaleY(0.5);

        secondi.setImage(new Image(IMAGESRC1));
        secondi.setScaleX(0.5);
        secondi.setScaleY(0.5);

        contorni.setImage(new Image(IMAGESRC1));
        contorni.setScaleX(0.5);
        contorni.setScaleY(0.5);

        colazioni.setImage(new Image(IMAGESRC1));
        colazioni.setScaleX(0.5);
        colazioni.setScaleY(0.5);

        dessert.setImage(new Image(IMAGESRC1));
        dessert.setScaleX(0.5);
        dessert.setScaleY(0.5);

        antipasti.setImage(new Image(IMAGESRC1));
        antipasti.setScaleX(0.5);
        antipasti.setScaleY(0.5);


    }

    public void clickSearch()  {
        //
    }

    public void selectPrimi() {
        if (Boolean.TRUE.equals(portata[1])) {
            portata[0] = false;
            primi.setImage(new Image(IMAGESRC1));
        } else {
            portata[0] = true;
            primi.setImage(new Image(IMAGESRC2));
        }
    }
    public void selectSecondi() {
        if (Boolean.TRUE.equals(portata[1])) {
            portata[1] = false;
            secondi.setImage(new Image(IMAGESRC1));
        } else {
            portata[1] = true;
            secondi.setImage(new Image(IMAGESRC2));
        }
    }
    public void selectContorni() {
        if (Boolean.TRUE.equals(portata[2])) {
            portata[2] = false;
            contorni.setImage(new Image(IMAGESRC1));
        } else {
            portata[2] = true;
            contorni.setImage(new Image(IMAGESRC2));
        }
    }
    public void selectColazioni() {
        if (Boolean.TRUE.equals(portata[3])) {
            portata[3] = false;
            colazioni.setImage(new Image(IMAGESRC1));
        } else {
            portata[3] = true;
            colazioni.setImage(new Image(IMAGESRC2));
        }
    }
    public void selectDessert() {
        if (Boolean.TRUE.equals(portata[4])) {
            portata[4] = false;
            dessert.setImage(new Image(IMAGESRC1));
        } else {
            portata[4] = true;
            dessert.setImage(new Image(IMAGESRC2));
        }
    }
    public void selectAntipasti() {
        if (Boolean.TRUE.equals(portata[5])) {
            portata[5] = false;
            antipasti.setImage(new Image(IMAGESRC1));
        } else {
            portata[5] = true;
            antipasti.setImage(new Image(IMAGESRC2));
        }
    }

    public void hoverPrimi()  {
        primi.setScaleX(1.5);
        primi.setScaleY(1.5);
    }
    public void hoverSecondi() {
        secondi.setScaleX(1.5);
        secondi.setScaleY(1.5);
    }
    public void hoverContorni() {
        contorni.setScaleX(1.5);
        contorni.setScaleY(1.5);
    }
    public void hoverColazioni()  {
        colazioni.setScaleX(1.5);
        colazioni.setScaleY(1.5);
    }
    public void hoverDessert()  {
        dessert.setScaleX(1.5);
        dessert.setScaleY(1.5);
    }
    public void hoverAntipasti()   {
        antipasti.setScaleX(1.5);
        antipasti.setScaleY(1.5);
    }

    public void releasePrimi() {
        primi.setScaleX(0.5);
        primi.setScaleY(0.5);
    }
    public void releaseSecondi() {
        secondi.setScaleX(0.5);
        secondi.setScaleY(0.5);
    }
    public void releaseContorni() {
        contorni.setScaleX(0.5);
        contorni.setScaleY(0.5);
    }
    public void releaseColazioni()  {
        colazioni.setScaleX(0.5);
        colazioni.setScaleY(0.5);
    }
    public void releaseDessert()  {
        dessert.setScaleX(0.5);
        dessert.setScaleY(0.5);
    }
    public void releaseAntipasti()  {
        antipasti.setScaleX(0.5);
        antipasti.setScaleY(0.5);
    }

    public void removeFilter() {
        String img =IMAGESRC1;
        int i;
        for (i=0;i<6;i++) {
            portata[i] = false;
        }

        primi.setImage(new Image(img));
        secondi.setImage(new Image(img));
        contorni.setImage(new Image(img));
        colazioni.setImage(new Image(img));
        dessert.setImage(new Image(img));
        antipasti.setImage(new Image(img));


    }


    public void clickSearchButton() throws IOException {
        General2.changeScene(General2.setSource("Search2"));
    }

    public void clickAddButton() throws IOException {
        General2.changeScene(General2.setSource("Add2"));
    }

    public void clickLoginButton() throws IOException {
        General2.changeScene(General2.setSource(LOGIN));
    }

    public void clickFavouriteButton() throws IOException {
        PendentScreen2 ps3;
        ps3 = Home2.getPS2();
        ps3.setScreen2("1");
        if (General2.getLoginStateSView()) {
            General2.changeScene(General2.setSource("Favourite2"));
        } else {
            ps3 = Home2.getPS2();
            ps3.add("Favourite2.fxml");
            General2.changeScene(General2.setSource(LOGIN));
        }      }

    public void clickFridgeButton() throws IOException {
        PendentScreen2 ps4;
        ps4 = Home2.getPS2();
        ps4.setScreen2("1");
        if (General2.getLoginStateSView()) {
            General2.changeScene(General2.setSource("Fridge2"));
        } else {
            ps4 = Home2.getPS2();
            ps4.add("Fridge2.fxml");
            General2.changeScene(General2.setSource(LOGIN));
        }
    }

    public void clickReviewButton() throws IOException {
        General2.changeScene(General2.setSource("Review2"));
    }


    public void clickHomeButton() throws IOException {
        General2.changeScene(General2.setSource("Home2"));
    }

    public void clickBackButton() throws IOException {
        //
    }

    public void clickInsertIngredients() throws IOException {
        General2.changeScene(General2.setSource("Ingredients2"));
    }

    public void clickRecipesButton() throws IOException {
        ps.setScreen2("1");
        General2.changeScene(General2.setSource("Result2"));
    }
}
