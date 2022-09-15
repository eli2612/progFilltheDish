package home.home2.model.dao.queries;

import home.home2.model.IngredientEntity;

import java.io.InputStream;
import java.sql.*;

public class Queries {


    private Queries() {
    }


    public static ResultSet credentials(Statement stmt, String username, String password) throws SQLException {

        String selectCredentials = String.format("Select * From utenti Where username ='%s' AND password ='%s'", username, password);
        return stmt.executeQuery(selectCredentials);

    }


    public static void enroll(Statement stmt, String username, String nome, String cognome, String email, String password) throws SQLException {

        String enrollNow = String.format("INSERT INTO `utenti`(username, nome, cognome, email, password) VALUES ('%s','%s','%s','%s','%s')", username, nome, cognome, email, password);
        stmt.executeUpdate(enrollNow);   //ritorna un intero con il numero di righe aggiunte

    }


    public static ResultSet getImageFromIng(Statement stmt, String ingredient) throws SQLException {

        String selectImage = String.format("SELECT * from `ingredienti` where nome = '%s'", ingredient);
        return stmt.executeQuery(selectImage);
    }


    public static void insertIntoFridge(Connection conn, String username, IngredientEntity ingredient, InputStream ingredientImageInputStream) throws SQLException {

        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO `frigo`(utente,ingrediente,immagine) values (?,?,?)");
        try {
            pstmt.setString(1, username);
            pstmt.setString(2, ingredient.getIngredient());
            pstmt.setBlob(3, ingredientImageInputStream);

            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pstmt.close();
        }

    }

    public static ResultSet takeIngredientsDB(Statement stmt) throws SQLException {
        String takeIng = "SELECT nome FROM ingredienti";
        return stmt.executeQuery(takeIng);
    }


    public static ResultSet getIngredientsFromFridge(Statement stmt, String username) throws SQLException {
        String ingredients = String.format("SELECT * FROM `frigo` where `utente` = '%s'", username);
        return stmt.executeQuery(ingredients);
    }

    public static void deleteFromFridge(Statement stmt, String username, String ingredient) throws SQLException {
        String delete = String.format("DELETE FROM `frigo` WHERE `utente` = '%s' AND `ingrediente` = '%s' ", username, ingredient);
        stmt.executeUpdate(delete);
    }


    public static ResultSet getRecipesName(Statement stmt) throws SQLException {

        String selectRecipeName = "SELECT * FROM `ricetta`";
        return stmt.executeQuery(selectRecipeName);

    }

    public static ResultSet selectRecipesIngredients(Statement stmt, String ricetta) throws SQLException {

        String recIngredients = String.format("SELECT `ingrediente` FROM `componenti` WHERE `ricetta` = '%s' ", ricetta);

        return stmt.executeQuery(recIngredients);

    }

    public static void  insertIntoFavourites(Statement stmt, String username, String recipeName) throws SQLException {
        String insertQuery = String.format("INSERT INTO `ricettePreferiteUtente`(utente,ricetta) VALUES ('%s', '%s')", username, recipeName);
        stmt.executeUpdate(insertQuery);
    }

    public static ResultSet favouritesRecipes(Statement stmt, String username) throws SQLException {
        String favourites = String.format("SELECT * FROM `ricettePreferiteUtente` WHERE `utente` = '%s'", username);
        return stmt.executeQuery(favourites);
    }

    public static ResultSet getRecipeImage(Statement stmt, String recipeName) throws SQLException {
        String image = String.format("SELECT *  FROM `ricetta` WHERE `id_ricetta` = '%s' ",recipeName);
        return stmt.executeQuery(image);
    }

    public static void deleteFromFavourites(Statement stmt, String username, String recipeName) throws SQLException {
        String deleteQuery = String.format("DELETE FROM `ricettePreferiteUtente` WHERE utente = '%s' and ricetta = '%s' ", username,recipeName);
        stmt.executeUpdate(deleteQuery);
    }

}







