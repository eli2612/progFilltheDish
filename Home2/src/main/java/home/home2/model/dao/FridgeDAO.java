package home.home2.model.dao;

import home.home2.model.dao.queries.DBConnection;
import home.home2.model.dao.queries.Queries;
import home.home2.model.IngredientEntity;
import home.home2.model.User;
import javafx.scene.image.Image;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FridgeDAO {



    public  IngredientEntity ingredientImage(String ingredient) {
        Statement stmt = null;
        Connection conn = null;

        IngredientEntity insertIngredient = null;

        try{

            conn = DBConnection.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet resultSet = Queries.getImageFromIng(stmt, ingredient);

            if (!resultSet.first()) {
                return insertIngredient;
            }

            resultSet.first();
            insertIngredient = new IngredientEntity();
            insertIngredient.setIngredient(resultSet.getString("nome"));

            Blob b = resultSet.getBlob("immagine");
            if (b != null) {
                InputStream inputStream = b.getBinaryStream();
                Image image = new Image(inputStream);
                insertIngredient.setIngredientSrc(image);
            }

        }catch(Exception e){
            e.printStackTrace();
        }


        return insertIngredient;
    }


    public  void insertInFridge(String username, IngredientEntity ingredient, InputStream ingredientInputStream){
        Connection conn = null;

        try{
            conn = DBConnection.getInstance().getConnection();
            Queries.insertIntoFridge(conn,username,ingredient,ingredientInputStream);

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public  IngredientEntity createIngredient(ResultSet resultSet) throws SQLException {

        Image image = null;
        String ingredientName = resultSet.getString("ingrediente");


        Blob bl = resultSet.getBlob("immagine");
        if (bl != null) {
            InputStream inputStream = bl.getBinaryStream();
            image = new Image(inputStream);


        }

        return new IngredientEntity(ingredientName, image);
    }


    public  List<IngredientEntity> ingredientUser(String username) {
        Statement stmt = null;
        Connection conn = null;

        List<IngredientEntity> ingredients = new ArrayList<>() ;

        try{
            conn = DBConnection.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet resultSet = Queries.getIngredientsFromFridge(stmt, username);

            if(!resultSet.first()){
                return ingredients;
            }

            resultSet.first();

            do{
                ingredients.add(createIngredient(resultSet));
            }while(resultSet.next());

        }catch(Exception e){
            e.printStackTrace();
        }

        return ingredients;
    }

    public  void delete(String ingredient){
        Statement stmt = null;
        Connection conn = null;

        try{
            conn = DBConnection.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            Queries.deleteFromFridge(stmt, User.getInstance().getUser().getUsername(), ingredient);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
