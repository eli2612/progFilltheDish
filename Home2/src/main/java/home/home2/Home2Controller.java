package home.home2;

import java.io.IOException;

import static home.home2.Home2.ps;

public class Home2Controller  {

    public static final String LOGINSTRING = "Login2";

    public void clickHomeButton() throws IOException {
        General2.changeScene(General2.setSource("Home2"));
    }

    public void clickSearchButton() throws IOException {
        General2.changeScene(General2.setSource("Search2"));

    }
    public void clickAddButton() throws IOException {
        General2.changeScene(General2.setSource("Add2"));

    }
    public void clickLoginButton() throws IOException {
        General2.changeScene(General2.setSource(LOGINSTRING));

    }
    public  void clickFavouriteButton() throws IOException {
        PendentScreen2 ps1 = Home2.getPS2();
        if (General2.getLoginStateSView()) {
            General2.changeScene(General2.setSource("Favourite2"));
        } else {
            ps1.add("Favourite2.fxml");
            General2.changeScene(General2.setSource(LOGINSTRING));
        }
    }
    public void clickReviewButton() throws IOException {
        General2.changeScene(General2.setSource("Review2"));
    }

    public  void clickFridgeButton() throws IOException {
        PendentScreen2 ps2 = Home2.getPS2();
        if (General2.getLoginStateSView()) {
            General2.changeScene(General2.setSource("Fridge2"));
        } else {
            ps2.add("Fridge2.fxml");
            General2.changeScene(General2.setSource(LOGINSTRING));
        }
    }

    public void clickInsertIngredients() throws IOException {
        General2.changeScene(General2.setSource("Ingredients2"));
    }

    public void clickRecipesButton() throws IOException {
        ps.setScreen2("1");
        General2.changeScene(General2.setSource("Result2"));
    }


}
