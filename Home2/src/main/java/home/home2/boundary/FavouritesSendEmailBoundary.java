package home.home2.boundary;

import home.home2.beans.FavouritesBean;
import home.home2.model.User;

import javax.mail.MessagingException;

public class FavouritesSendEmailBoundary extends JavaMailUtilsBoundary {

    public void send(FavouritesBean favbean){

        try{
            String subject = "Aggiornamento Frigo";
            String message = "Un saluto da parte dei sviluppatori di Fill The Dish! l'ingrediente : "+favbean.getRecipeName()+", è stato aggiunto correttamente nel tuo frigo virtuale!";

            JavaMailUtilsBoundary.sendEmail(User.getInstance().getUser().getEmail(), subject,message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
