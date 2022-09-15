package junit;
import home.home2.beans.EnrollBean;
import home.home2.controller.EnrollController;
import home.home2.model.exceptions.FailedRegistrationException;
import home.home2.model.exceptions.InvalidSyntaxEmailException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
class TestEnrollController {

    private static final String USERNAME = "Eli";
    private static final String NAME = "Elisa";
    private static final String SURNAME = "Ferrari";
    private static final String PASSWORD = "elisa";

    private static final String NEWUSERNAME = "Mary";
    private static final String NEWNAME = "Maria";
    private static final String NEWSURNAME = "Bianchi";
    private static final String NEWEMAIL = "mbianchi@hotmail.it";
    private static final String NEWPASSWORD = "maria";

    @Test
    void testEnrollInvalidSyntaxEmail(){

        EnrollBean enrollBean = new EnrollBean();
        EnrollController enrollController = new EnrollController();
        enrollBean.setUsername(USERNAME);
        enrollBean.setName(NAME);
        enrollBean.setCognome(SURNAME);
        enrollBean.setEmail("emailsbagliata.com");
        enrollBean.setPassword(PASSWORD);
        assertThrows(InvalidSyntaxEmailException.class, ()->enrollController.addUser(enrollBean));
    }


    @Test

    void testEnrollPasswordTooShort(){

        EnrollBean enrollBean = new EnrollBean();
        EnrollController enrollController = new EnrollController();
        enrollBean.setUsername(NEWUSERNAME);
        enrollBean.setName(NEWNAME);
        enrollBean.setCognome(NEWSURNAME);
        enrollBean.setEmail(NEWEMAIL);
        enrollBean.setPassword(NEWPASSWORD);

        assertThrows(FailedRegistrationException.class, ()->enrollController.addUser(enrollBean));


    }

    @Test



    void testEnrollCorrectAccount(){
        boolean enrollmentSuccess;



        EnrollBean enrollBean = new EnrollBean();
        enrollBean.setUsername("Marione");
        enrollBean.setName("Mario");
        enrollBean.setCognome("Rossi");
        enrollBean.setEmail("mariorossi@libero.it");
        enrollBean.setPassword("mariorossi01");



        try{
            EnrollController enrollController = new EnrollController();
            enrollController.addUser(enrollBean);
            enrollmentSuccess = true;



        }catch (FailedRegistrationException | InvalidSyntaxEmailException e ){
            enrollmentSuccess = false;



        }
        assertEquals(true, enrollmentSuccess);
    }




    @Test
    void testEnrollEmptyFields(){



        EnrollController enrollController = new EnrollController();



        EnrollBean enrollBean = new EnrollBean();



        enrollBean.setUsername("");
        enrollBean.setName("Mario");
        enrollBean.setCognome("Rossi");
        enrollBean.setEmail("mariorossi@libero.it");
        enrollBean.setPassword("mariorossi01");



        assertThrows(FailedRegistrationException.class, ()->enrollController.addUser(enrollBean));
    }
}