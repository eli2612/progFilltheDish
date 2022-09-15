package home.home2.controller;

import home.home2.beans.CalculateRecipeBean;
import home.home2.beans.IngredientBean;
import home.home2.model.dao.CalculateRecipeDAO;
import home.home2.model.Ingredient;
import home.home2.model.RecipeEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CalculateRecipeController {


    public List<CalculateRecipeBean> checkIngredients(CalculateRecipeBean recipeBean) throws SQLException {

        List<CalculateRecipeBean> recipesresultBeans = new ArrayList<>();

        CalculateRecipeDAO rDao = new CalculateRecipeDAO();

        List<RecipeEntity> recipes = rDao.recipes(recipeBean.getListIng());  //vedi controller insertIngredientsController

        for(RecipeEntity i : recipes ){
            recipesresultBeans.add(new CalculateRecipeBean(i.getRecipe(),i.getDescrizione(),i.getRecipeSrc(),i.getType()));
        }


        return recipesresultBeans; // ritorna una lista di ricette complete (nome..descrizione..)
    }



    public  List<IngredientBean> getIngredients(CalculateRecipeBean recipeBean){

        List<IngredientBean> ingredientBeans = new ArrayList<>();
        List<Ingredient> ingredients = CalculateRecipeDAO.recipesIngredients(recipeBean.getName());

        for(Ingredient ingr : ingredients){
            ingredientBeans.add(new IngredientBean(ingr.getName()));
        }

        return ingredientBeans;

    }



}

