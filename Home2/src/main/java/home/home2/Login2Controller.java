package home.home2;

import home.home2.controller.EnrollController;
import home.home2.controller.LoginController;
import home.home2.beans.EnrollBean;
import home.home2.beans.LoginBean;
import home.home2.model.exceptions.FailedRegistrationException;
import home.home2.model.exceptions.InvalidSyntaxEmailException;
import home.home2.model.exceptions.LoginFailedException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

import static home.home2.Home2.ps;

public class Login2Controller {

    private static final String LOGIN = "Login2";

     @FXML
     private TextField username;

     @FXML
     private PasswordField password;

     @FXML
     private TextField name;

    @FXML
    private TextField lastname;

    @FXML
    private TextField email;

    @FXML
    private TextField userN;

    @FXML
    private PasswordField passW;

    @FXML
    private PasswordField repeatPassword;


     @FXML
    public void clickLogin() throws IOException,LoginFailedException {

         General2.setLoginStateSview(true);

         LoginBean loginB = new LoginBean();
        loginB.setUsername(username.getText());
        loginB.setPassword(password.getText());

        username.setText("");
        password.setText("");

        LoginController loginC = new LoginController();
        if(!loginC.login(loginB)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Credenziali Errate!");
            alert.show();
        }
        else{
            //
            if(Boolean.TRUE.equals(ps.isNull())){
                General2.changeScene(General2.setSource("Home2"));
            }
            else{
               General2.changeScene(ps.get());
            }

        }

    }

    public void clickRegister()  {

        EnrollBean enrollbean = new EnrollBean();
        enrollbean.setUsername(userN.getText());
        enrollbean.setName(name.getText());
        enrollbean.setCognome(lastname.getText());
        enrollbean.setEmail(email.getText());
        enrollbean.setPassword(passW.getText());

        EnrollController controller = new EnrollController();

        try{
            if (controller.addUser(enrollbean) && enrollbean.getPassword().equals(repeatPassword.getText())) {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.show();

                userN.setText("");
                name.setText("");
                lastname.setText("");
                email.setText("");
                passW.setText("");
                repeatPassword.setText("");

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Le due password non coincidono!");
                alert.show();
            }

        }catch (FailedRegistrationException e){
            e.printStackTrace();
        }catch (InvalidSyntaxEmailException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Inserisci un indirizzo mail valido");
            alert.show();
        }

    }

    public void clickInterfaceButton() {
         // No
    }

    public void clickReviewButton() throws IOException {
        General2.changeScene(General2.setSource("Review2"));

    }

    public void clickFridgeButton() throws IOException {
         PendentScreen2 ps = Home2.getPS2();
        if (General2.getLoginStateSView()) {
            General2.changeScene(General2.setSource("Fridge2"));
        } else {
            ps.add("Fridge2.fxml");
            General2.changeScene(General2.setSource(LOGIN));
        }

    }

    public void clickFavouriteButton() throws IOException {
         PendentScreen2 ps = Home2.getPS2();
        if (General2.getLoginStateSView()) {
            General2.changeScene(General2.setSource("Favourite2"));
        } else {
            ps.add("Favourite2.fxml");
            General2.changeScene(General2.setSource(LOGIN));
        }

    }

    public void clickLoginButton() throws IOException {
        General2.changeScene(General2.setSource(LOGIN));

    }

    public void clickAddButton() throws IOException {
        General2.changeScene(General2.setSource("Add2"));

    }

    public void clickSearchButtonLog2() throws IOException {
        General2.changeScene(General2.setSource("Search2"));

    }

    public void clickHomeButtonLog2() throws IOException {
         General2.changeScene(General2.setSource("Home2"));
    }

    public void clickBackButton() {
         //
    }

    public void clickInsertIngredientsLog2() throws IOException {
         General2.changeScene(General2.setSource("Ingredients2"));
    }

    public void clickRecipesButtonLog2() throws IOException {
         PendentScreen2 ps = Home2.getPS2();
         ps.setScreen2("1");
        General2.changeScene(General2.setSource("Result2"));
    }
}
