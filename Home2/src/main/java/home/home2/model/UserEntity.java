package home.home2.model;


import java.util.ArrayList;
import java.util.List;

public class UserEntity {

    String username;
    String password;
    String name;
    String surname;
    String email;

    public final  FridgeSingletonEntity fridge;
    public final List<RecipeEntity> favourites;


    public UserEntity(FridgeSingletonEntity fridge,List<RecipeEntity> favourites, String username){
        this.fridge = fridge;
        this.username = username;
        this.favourites = favourites;
    }

    // Non va bene perche in questo istante ancora non e stato loggato, quindi non posso recuperare
    // Le credenziali dell'utente in modo da avere le istanze di fridge e favourites però vabbè
    public UserEntity(){
        this.fridge= null;
        this.favourites = new ArrayList<>();
    }


    public List<RecipeEntity> getFavourites(){
      return FavouritesEntity.getInstance().getUserFavouritesList();
    }

    public static FridgeSingletonEntity getFridge(){
        return FridgeSingletonEntity.getInstance();
    }

    public void setUsername(String userN){
        this.username = userN;
    }

    public String getUsername(){
        return username;
    }

    public void setPassword(String pass){
        this.password = pass;
    }

    public String getPassword(){
        return password;
    }

    public void setEmail(String mail){
        this.email = mail;
    }

    public String getEmail(){
        return email;
    }

    public void setName(String nome){
        this.name = nome;
    }

    public String getName(){
        return name;
    }

    public void setSurname(String surN){
        this.surname = surN;
    }

    public String getSurname(){
        return surname;
    }


}
