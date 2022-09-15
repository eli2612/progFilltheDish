package home.home2.model;

import javafx.scene.image.Image;

public class IngredientEntity {

    String name;
    Image image;

    public IngredientEntity(){
    }

    public IngredientEntity(String nome , Image immagine){
        this.name = nome;
        this.image = immagine;
    }

    public IngredientEntity(String ingredientName) {
    }

    public String getIngredient(){
        return name;
    }

    public void setIngredient(String ingr){
        this.name = ingr;
    }

    public Image getIngredientSrc(){
        return image;
    }

    public void setIngredientSrc(Image im){
        this.image = im;
    }


}
