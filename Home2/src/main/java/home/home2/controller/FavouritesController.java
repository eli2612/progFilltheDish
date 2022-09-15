package home.home2.controller;

import home.home2.boundary.FavouritesSendEmailBoundary;
import home.home2.model.*;
import home.home2.beans.FavouritesBean;
import home.home2.model.dao.FavouritesDAO;
import home.home2.model.exceptions.DuplicateRecipeException;
import home.home2.model.exceptions.ProvideLoginException;

import java.util.ArrayList;
import java.util.List;

public class FavouritesController {

     public final FavouritesEntity favouritesList ;
     List<RecipeEntity> favourites;


    public FavouritesController() throws ProvideLoginException {
        FavouritesDAO favouritesD = new FavouritesDAO();

        if(User.getInstance().getUser() == null){
            throw new ProvideLoginException();
        }
        favourites = favouritesD.userFavourites(User.getInstance().getUser().getUsername());
        favouritesList = FavouritesEntity.createFavouritesList(favourites,User.getInstance().getUser().getUsername());
    }

    public void addToFavourites(FavouritesBean favouritesbean) throws DuplicateRecipeException {
        FavouritesDAO favouritesD = new FavouritesDAO();
        for(RecipeEntity recipe : User.getInstance().getUser().getFavourites()){
            if(recipe.getRecipe().equals(favouritesbean.getRecipeName())){
                throw new DuplicateRecipeException("Ingrediente gia esistente nella lista di preferiti");
            }
        }

        RecipeEntity recipeEntity;

        recipeEntity = FavouritesEntity.getInstance().addToFavourites(favouritesbean.getRecipeName());

        favouritesD.insertIntoFavourites(User.getInstance().getUser().getUsername(),recipeEntity);

        FavouritesSendEmailBoundary fav = new FavouritesSendEmailBoundary();
        fav.send(favouritesbean);

    }

    public void deleteFromFavourites(FavouritesBean favouritesbean){
        FavouritesDAO favouritesD = new FavouritesDAO();
        RecipeEntity recipeEntity = new RecipeEntity(favouritesbean.getRecipeName());

        FavouritesEntity.getInstance().removeFromFavourites(recipeEntity);

        favouritesD.deleteFromFavourites(User.getInstance().getUser().getUsername(), favouritesbean.getRecipeName());

    }

    public  List<FavouritesBean> showFavourites(){
        FavouritesDAO favouritesD = new FavouritesDAO();
        List<FavouritesBean> favouritesBeans = new ArrayList<>();
        List<RecipeEntity> recipes = favouritesD.userFavourites(User.getInstance().getUser().getUsername());

        for(RecipeEntity recipe : recipes){
            favouritesBeans.add(new FavouritesBean(recipe.getRecipe(), recipe.getRecipeSrc()));
        }

        return favouritesBeans;
    }

}
