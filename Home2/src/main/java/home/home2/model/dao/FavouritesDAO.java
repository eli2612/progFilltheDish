package home.home2.model.dao;

import home.home2.model.dao.queries.DBConnection;
import home.home2.model.dao.queries.Queries;
import home.home2.model.RecipeEntity;
import javafx.scene.image.Image;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FavouritesDAO {



    public  void insertIntoFavourites(String username, RecipeEntity recipeEntity){
        Connection conn = null;
        Statement stmt = null;

        try{
            conn = DBConnection.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            Queries.insertIntoFavourites(stmt, username,recipeEntity.getRecipe());
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public  List<RecipeEntity> userFavourites(String username){
        Connection conn = null;
        Statement stmt = null;
        Statement stmt1 = null;
        List<RecipeEntity> recipes = new ArrayList<>();
        String recipeName;
        Image image = null;

        try{
            conn = DBConnection.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet resultSet = Queries.favouritesRecipes(stmt, username);

            if(!resultSet.first()){
                return recipes;
            }

            resultSet.first();
            do{
                recipeName = resultSet.getString("ricetta");
                ResultSet res = Queries.getRecipeImage(stmt1,recipeName);

                res.first();

                Blob bl = res.getBlob("immagine");
                    if(bl!=null){
                        InputStream inputStream = bl.getBinaryStream();
                        image = new Image(inputStream);
                    }
                    String description = res.getString("descrizione");
                    String type = res.getString("tipo");

                recipes.add( new RecipeEntity(recipeName,image,description,type));

            }while(resultSet.next());

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(stmt1 != null){
                    stmt1.close();
                }
                if(stmt != null){
                    stmt.close();
                }

            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return recipes;
    }

    public  void deleteFromFavourites(String username, String recipename){
        Connection conn = null;
        Statement stmt = null;

        try{
            conn = DBConnection.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            Queries.deleteFromFavourites(stmt, username, recipename);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


}
