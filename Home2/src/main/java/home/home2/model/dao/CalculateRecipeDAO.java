package home.home2.model.dao;

import home.home2.model.dao.queries.DBConnection;
import home.home2.model.dao.queries.Queries;
import home.home2.model.Ingredient;
import home.home2.model.RecipeEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class  CalculateRecipeDAO {


    public static ObservableList<Ingredient> ingredients() {
        Statement stmt = null;
        Connection conn = null;

        ObservableList<Ingredient> listaIng = FXCollections.observableArrayList();
        try{
            conn = DBConnection.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet res = Queries.takeIngredientsDB(stmt);

            if (!res.first()) {
                return listaIng;

            } else {
                while (res.next()) {
                    String ingredientName = res.getString("nome");
                    listaIng.add(new Ingredient(ingredientName));
                }
            }
        }catch(SQLException e){
                e.printStackTrace();
            }

            return listaIng;


    }

    public List<RecipeEntity> recipes(ObservableList<Ingredient> userIngredients) throws SQLException {
        Statement stmt = null;
        Statement stmt1 = null;
        Connection conn = null;
        List<RecipeEntity> recipes = new ArrayList<>();
        int count = 0;
        List<Ingredient> ingredients = new ArrayList<>();
        try{
            conn = DBConnection.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = Queries.getRecipesName(stmt);

            resultSet.first();
            while(resultSet.next()){

                RecipeEntity recipe = createRecipe(resultSet);

                ResultSet res = Queries.selectRecipesIngredients(stmt1,recipe.getRecipe());

                res.first();
                do{
                    ingredients.add(createIngredient(res));
                } while(res.next());

                for(Ingredient ingr : ingredients){
                    for(Ingredient ingr1 : userIngredients){
                        if(ingr.getName().equals(ingr1.getName())){
                            count++;
                        }
                    }
                }

               if(count >= 2){
                   recipes.add(new RecipeEntity(recipe.getRecipe(),recipe.getRecipeSrc(),recipe.getDescrizione(),recipe.getType()));
                }

                ingredients.clear();
               count = 0;

            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
           stmt1.close();
        }
        return recipes;
    }

    private RecipeEntity createRecipe(ResultSet resultSet) throws SQLException {
        Image image = null;
        String name = resultSet.getString("id_ricetta");
        String tipologia = resultSet.getString("tipo");
        String descrizione = resultSet.getString("descrizione");
        Blob bl = resultSet.getBlob("immagine");
        if(bl != null){
            InputStream inputStream = bl.getBinaryStream();
            image = new Image(inputStream);
        }

        return new RecipeEntity(name,image,descrizione,tipologia);
    }

    private Ingredient createIngredient(ResultSet res) throws SQLException {

            String recipeName = res.getString("ingrediente");
            return new Ingredient(recipeName);
    }


    public static List<Ingredient> recipesIngredients(String recipe)  {

        Statement stmt = null;
        Connection conn = null;

        List<Ingredient> ingredients = new ArrayList<>();

        try{
            conn = DBConnection.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet resultSet = Queries.selectRecipesIngredients(stmt,recipe);
            if(!resultSet.first()){
                return ingredients;
            }

            resultSet.first();
            do{
                String name = resultSet.getString("ingrediente");

                ingredients.add(new Ingredient(name));

            }while(resultSet.next());


        }catch(SQLException e){
            e.printStackTrace();
        }

        return ingredients;

    }

}







