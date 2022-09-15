package home.home2.controller;

import home.home2.beans.FridgeBean;
import home.home2.boundary.ManageFridgeSendEmailBoundary;
import home.home2.model.dao.FridgeDAO;
import home.home2.model.exceptions.DuplicateIngredientException;
import home.home2.model.IngredientEntity;
import home.home2.model.FridgeSingletonEntity;
import home.home2.model.User;
import java.util.ArrayList;
import java.util.List;

public class ManageFridgeController {

    public final FridgeSingletonEntity fridge;
    List<IngredientEntity> ingredients;


    public ManageFridgeController(){   //metodo che recupera gli ingredienti del frigo dell'utente
        FridgeDAO fridgeDAO = new FridgeDAO();
        ingredients = fridgeDAO.ingredientUser(User.getInstance().getUser().getUsername());
        this.fridge = FridgeSingletonEntity.createFridge(ingredients,User.getInstance().getUser().getUsername());

    }

    public void addIngredient(FridgeBean fridgebean) throws DuplicateIngredientException {
        FridgeDAO fridgeDAO = new FridgeDAO();
        for(IngredientEntity ingr : ingredients){
            if(ingr.getIngredient().equals(fridgebean.getIngredientName())){
               throw new DuplicateIngredientException("This ingredient already exist !");
            }
        }

        IngredientEntity ingredient = fridge.addIngredient(fridgebean.getIngredientName(), fridgebean.getIngredientImage());
        fridgeDAO.insertInFridge(User.getInstance().getUser().getUsername(),ingredient, fridgebean.getIngredientInputStream());

        ManageFridgeSendEmailBoundary email = new ManageFridgeSendEmailBoundary();
        email.send(fridgebean);

    }


     public List<FridgeBean> showFridge(){
        List<FridgeBean> ingredientListBean = new ArrayList<>();

        ingredients = fridge.getIngredientList();

        for(IngredientEntity ingr : ingredients){
           ingredientListBean.add(new FridgeBean(ingr.getIngredient(), ingr.getIngredientSrc()));
        }

        return ingredientListBean;
    }



    public  boolean getImage(FridgeBean fb){
        FridgeDAO fridgeDAO = new FridgeDAO();

        IngredientEntity ingredient =  fridgeDAO.ingredientImage(fb.getIngredientName());

        if(ingredient != null){

            fb.setIngredientImage(ingredient.getIngredientSrc());

            return true;
        }
        else{
            return false;
        }

    }


    public void deleteIngredient(FridgeBean fridgebean) {
        FridgeDAO fridgeDAO = new FridgeDAO();

        IngredientEntity ingredient = new IngredientEntity(fridgebean.getIngredientName(), fridgebean.getIngredientImage());

        FridgeSingletonEntity.getInstance().removeIngredient(ingredient);

        fridgeDAO.delete(fridgebean.getIngredientName());
    }
}
