package home.home2;

import home.home2.controller.FavouritesController;
import home.home2.controller.ManageFridgeController;
import home.home2.beans.FavouritesBean;
import home.home2.beans.FridgeBean;
import home.home2.model.exceptions.ProvideLoginException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ElementController2 {

    @FXML
    private Button name;

    @FXML
    private ImageView img;

    @FXML
    private Pane cover;

    FavouritesBean favBean;

    FridgeBean fridgebean;

    public void setData(FridgeBean fridgebean){
        this.fridgebean = fridgebean;
        name.setText(fridgebean.getIngredientName());
        img.setImage(fridgebean.getIngredientImage());
    }

    public void setData1(FavouritesBean favBean) {
        this.favBean = favBean;
        name.setText(favBean.getRecipeName());
        img.setImage(favBean.getRecipeImage());
    }

    public void removeIngredient() throws IOException {

        FridgeBean fridgebean1 = new FridgeBean();
        fridgebean1.setIngredientName(name.getText());
        ManageFridgeController fridgeController = new ManageFridgeController();
        fridgeController.deleteIngredient(fridgebean1);

        General2.changeScene(General2.setSource("Fridge2"));
    }

    @FXML
    public void clickRemoveRecipe() throws IOException, ProvideLoginException {

        FavouritesBean favBean1 = new FavouritesBean();
        favBean1.setRecipeName(name.getText());
        favBean1.setRecipeImage(img.getImage());

        FavouritesController favController = new FavouritesController();
        favController.deleteFromFavourites(favBean1);

        General2.changeScene(General2.setSource("Favourite2"));
    }
}
