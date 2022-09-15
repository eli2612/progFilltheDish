package home.home2;

import home.home2.controller.FavouritesController;
import home.home2.controller.ManageFridgeController;
import home.home2.beans.FavouritesBean;
import home.home2.beans.FridgeBean;
import home.home2.model.exceptions.ProvideLoginException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;


import java.io.*;


public class ElementController {
    @FXML
    private Button name;
    @FXML
    private ImageView img;

    FridgeBean fridgebean;

    FavouritesBean favBean;


    public void removeIngredient() throws IOException {

        FridgeBean fridgebean1 = new FridgeBean();
        fridgebean1.setIngredientName(name.getText());
        ManageFridgeController fridgeController = new ManageFridgeController();
        fridgeController.deleteIngredient(fridgebean1);

        General.changeScene(General.setSource("Fridge"));

    }

    public void setData(FavouritesBean favBean) {
        this.favBean = favBean;
        name.setText(favBean.getRecipeName());
        img.setImage(favBean.getRecipeImage());
    }


    public void setData2(FridgeBean fridgebean) {  //riempimento del vertical box quando clicco su aggiungi ingrediente
        this.fridgebean = fridgebean;
        name.setText(fridgebean.getIngredientName());
        img.setImage(fridgebean.getIngredientImage());

    }

    @FXML
    public void clickRemoveRecipe() throws IOException, ProvideLoginException {

        FavouritesBean favBean1 = new FavouritesBean();
        favBean1.setRecipeName(name.getText());
        favBean1.setRecipeImage(img.getImage());

        FavouritesController favController = new FavouritesController();
        favController.deleteFromFavourites(favBean1);

        General.changeScene(General.setSource("Favourite"));
    }


}