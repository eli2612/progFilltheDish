package home.home2.controller;

import home.home2.beans.CalculateRecipeBean;
import home.home2.model.dao.AllRecipesDAO;
import home.home2.model.RecipeEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AllRecipesController {

    public List<CalculateRecipeBean> allRecipes() throws SQLException {

        List<RecipeEntity> recipes = AllRecipesDAO.getAllRecipes();
        List<CalculateRecipeBean> recipeBeans = new ArrayList<>();

        for(RecipeEntity i : recipes){
            recipeBeans.add(new CalculateRecipeBean(i.getRecipe(),i.getDescrizione(),i.getRecipeSrc(),i.getType()));
        }
        return recipeBeans;
    }


}
