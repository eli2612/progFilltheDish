package home.home2.beans;


public class IngredientBean {

    String ingredient;

    public IngredientBean(String ingredient){
        this.ingredient = ingredient;
    }


    public void setIngredientName(String ingr){
        this.ingredient = ingr;
    }

    public String getIngredientName(){
        return ingredient;
    }

}
