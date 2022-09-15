package home.home2.model;

import home.home2.beans.FridgeBean;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;


public class FridgeSingletonEntity extends FridgeSubject{


    private final List<IngredientEntity> ingredientList ;
    private static FridgeSingletonEntity instance = null;
    String username ;

    public FridgeSingletonEntity(List<IngredientEntity> ingredientList, String userName) {
        this.ingredientList = ingredientList;
        this.username = userName;
    }


    public static synchronized FridgeSingletonEntity createFridge(List<IngredientEntity> ingredientList, String userName){

        if(instance != null){
            // Eccezione
        }
        instance =  new FridgeSingletonEntity(ingredientList,userName);

        return instance;

    }

    // In teoria non dovrei più fare la new
    public static  FridgeSingletonEntity getInstance(){
        if(instance == null){
                // Eccezione
        }
        return instance;
    }

    public FridgeSingletonEntity(){
        this.ingredientList = new ArrayList<>();
    }

    public List<IngredientEntity> getIngredientList(){
        return ingredientList;
    }

    public IngredientEntity addIngredient(String name, Image image){
        IngredientEntity ingrediente = new IngredientEntity();
        ingrediente.setIngredient(name);
        ingrediente.setIngredientSrc(image);

        ingredientList.add(ingrediente);

        FridgeBean f = new FridgeBean();
        f.setIngredientName(name);
        f.setIngredientImage(image);

        notifyObserversNewIngredient(f);

        return ingrediente;
    }

    public void removeIngredient(IngredientEntity ingredient){
        for(IngredientEntity ingr : ingredientList){
            if (ingr.getIngredient().equals(ingredient.getIngredient())){
                ingredientList.remove(ingredient);
            }
        }
    }

    // Devo prendere come parametro il nome dell'utente,
    // Il vecchio ingrediente ( quello da cambiare )
    // Ed il nuovo , in modo da passare il nuovo come argomento del setingredient name and source
    // O forse dovrei fare la modifica indipendente ? Tipo modifico nome , modifico immagine a piacere

    public void modifyIngredient(IngredientEntity oldIngredient, IngredientEntity newIngredient){
        for(IngredientEntity ingr : ingredientList){
            if(ingr.getIngredient().equals(oldIngredient.getIngredient())){
                ingr.setIngredient(newIngredient.getIngredient());
                ingr.setIngredientSrc(newIngredient.getIngredientSrc());
            }
        }
    }

}
