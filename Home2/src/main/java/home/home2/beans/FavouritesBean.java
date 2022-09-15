package home.home2.beans;

import javafx.scene.image.Image;

public class FavouritesBean {

    String recipeName;
    Image recipeImage;

    public FavouritesBean(){}

    public FavouritesBean(String recipeName, Image recipeImage){
        this.recipeName = recipeName;
        this.recipeImage = recipeImage;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public Image getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(Image recipeImage) {
        this.recipeImage = recipeImage;
    }
}
