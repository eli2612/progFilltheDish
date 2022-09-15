package home.home2.model;
import javafx.scene.image.Image;
public class RecipeEntity {

    String idRicetta;
    String descrizione;
    Image immagine;
    String tipo;

    public RecipeEntity(String nomeRicetta, Image imm, String descrizione, String tipologia){
        this.idRicetta = nomeRicetta;
        this.immagine = imm;
        this.descrizione = descrizione;
        this.tipo = tipologia;
    }

    public RecipeEntity(String recipeName) {
        this.idRicetta = recipeName;
    }

    public RecipeEntity() {

    }

    public String getRecipe(){
        return idRicetta;
    }
    public void setRecipe( String recipe){
        this.idRicetta = recipe;
    }

    public String getDescrizione(){ return descrizione;}

    public void setDescrizione(String description){
        this.descrizione = description;
    }

    public Image getRecipeSrc(){ return immagine;}

    public void setRecipeSrc(Image immagine){
        this.immagine = immagine;
    }


    public String getType(){ return tipo;}


    public void setType( String tipoRicetta){
        this.tipo = tipoRicetta;
    }




}