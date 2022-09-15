package home.home2.model.dao;
import home.home2.model.dao.queries.Queries;
import home.home2.model.dao.queries.DBConnection;

import home.home2.model.RecipeEntity;
import javafx.scene.image.Image;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class AllRecipesDAO {

    static Statement stmt = null;
    static Connection conn = null;

    private AllRecipesDAO(){}

    public static List<RecipeEntity> getAllRecipes() throws SQLException {

        List<RecipeEntity> allRecipes = new ArrayList<>();
        String recipeName;
        Image recipeIm = null;
        String description;
        String tipo;
        conn = DBConnection.getInstance().getConnection();
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = Queries.getRecipesName(stmt);
        while(rs.next()) {
            recipeName = rs.getString("id_ricetta");
            Blob bl = rs.getBlob("immagine");
            if (bl != null) {
                InputStream inputStream = bl.getBinaryStream();
                recipeIm = new Image(inputStream);
            }
            description = rs.getString("descrizione");
            tipo = rs.getString("tipo");
            allRecipes.add(new RecipeEntity(recipeName, recipeIm, description, tipo));
        }
        return allRecipes;
    }

}