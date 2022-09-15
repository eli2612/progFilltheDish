package home.home2;

import home.home2.model.Ingredient;
import home.home2.model.SystemFridge;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import java.net.URL;
import java.util.ResourceBundle;

public class DynamicCBController implements Initializable {
    @FXML
    private ChoiceBox<String> choiceBoxD;

    public void initialize(URL url, ResourceBundle resourceBundle) {

        selectedIngredients.clear();

        choiceBoxD.setValue("Inserisci un nuovo ingrediente");

        SystemFridge fridge = SystemFridge.getInstance();

        ObservableList<Ingredient> ingredients = fridge.getIngredients();

        ObservableList<String> ingredientsString = FXCollections.observableArrayList();
        for (Ingredient i : ingredients) {
            ingredientsString.add(i.getName());
        }

        choiceBoxD.setItems(ingredientsString);


    }


    private static final ObservableList<Ingredient> selectedIngredients = FXCollections.observableArrayList();

    public ObservableList<Ingredient> getValues() {

        return selectedIngredients;
    }

    public void getChoiceBoxValue() {

        String ingrediente = choiceBoxD.getValue();

        SystemFridge fridge = SystemFridge.getInstance();

        ObservableList<Ingredient> ingredients = fridge.getIngredients();

        for (Ingredient i : ingredients) {
            if (ingrediente.equals(i.getName())) {
                selectedIngredients.add(new Ingredient(ingrediente));
            }
        }

    }
}




