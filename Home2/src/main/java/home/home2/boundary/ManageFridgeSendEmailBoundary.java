package home.home2.boundary;

import home.home2.beans.FridgeBean;
import home.home2.model.User;

import javax.mail.MessagingException;

public class ManageFridgeSendEmailBoundary extends JavaMailUtilsBoundary {

  public void send(FridgeBean fridgeBean){

      try{
          String subject = "Aggiornamento Frigo";
          String message = "Un saluto da parte dei sviluppatori di Fill The Dish! l'ingrediente : "+fridgeBean.getIngredientName()+", è stato aggiunto correttamente nel tuo frigo virtuale!";

          JavaMailUtilsBoundary.sendEmail(User.getInstance().getUser().getEmail(), subject,message);
      } catch (MessagingException e) {
          e.printStackTrace();
      }

  }
}
