package home.home2;

import home.home2.beans.IngredientBean;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class IngredientController {

    @FXML
    private Label ingrediente;

    IngredientBean ingrBean;

    public void setData(IngredientBean ingrBean){
        this.ingrBean = ingrBean;
        ingrediente.setText(ingrBean.getIngredientName());
    }

}
