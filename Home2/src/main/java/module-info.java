module home.home2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.mail;


    opens home.home2 to javafx.fxml;
    exports home.home2;
    exports home.home2.model;
    opens home.home2.model to javafx.fxml;


}