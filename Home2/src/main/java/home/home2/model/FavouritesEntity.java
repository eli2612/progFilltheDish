package home.home2.model;

import java.util.List;

public class FavouritesEntity {

    private static FavouritesEntity instance = null;
    public final List<RecipeEntity> favourites;
     String username;

    public FavouritesEntity(List<RecipeEntity> favourites, String username){
        this.favourites = favourites;
        this.username = username;
    }

    public static synchronized FavouritesEntity createFavouritesList(List<RecipeEntity> favourites, String username){
        if (instance != null){
//
        }
        instance = new FavouritesEntity(favourites, username);
        return instance;
    }

    public static FavouritesEntity getInstance(){
        if(instance == null){
            //exception
        }
        return instance;
    }

    public List<RecipeEntity> getUserFavouritesList(){
        return favourites;
    }

    public  RecipeEntity addToFavourites(String name){
        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setRecipe(name);

        favourites.add(recipeEntity);

        return recipeEntity;

    }

    public  void removeFromFavourites(RecipeEntity recipeEntity){
        for(RecipeEntity recipe : favourites){
            if(recipe.getRecipe().equals(recipeEntity.getRecipe())){
                favourites.remove(recipeEntity);
            }
        }

    }


}
