package home.home2.model;

import home.home2.model.dao.CalculateRecipeDAO;
import javafx.collections.ObservableList;

public class SystemFridge {

    public final ObservableList<Ingredient> ingredients;

    private static SystemFridge instance = null;

    public static synchronized SystemFridge getInstance(){
        if(instance == null){
            instance = new SystemFridge();
        }
        return instance;
    }

    private SystemFridge(){
        this.ingredients = CalculateRecipeDAO.ingredients();
    }

    public ObservableList<Ingredient> getIngredients() {
        return ingredients;
    }

}
