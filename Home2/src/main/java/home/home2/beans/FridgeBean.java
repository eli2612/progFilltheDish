package home.home2.beans;

import javafx.scene.image.Image;

import java.io.InputStream;

public class FridgeBean {

    private String ingredient;
    private Image image;
    private  InputStream ingredientInputStream;

    public FridgeBean(){}

    public FridgeBean(String ingredient, Image image){
        this.ingredient = ingredient;
        this.image = image;
    }

    public InputStream getIngredientInputStream(){
        return ingredientInputStream;
    }

    public void setIngredientInputStream(InputStream ingredientInputStream){
        this.ingredientInputStream = ingredientInputStream;
    }

    public void setIngredientName(String ingr){
        this.ingredient = ingr;
    }

    public String getIngredientName(){
        return ingredient;
    }

    public void setIngredientImage(Image img){
        this.image = img;
    }

    public Image getIngredientImage(){
        return image;
    }




}
