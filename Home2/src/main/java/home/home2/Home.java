package home.home2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Home extends Application {
    private static Stage stg;
    static  List<String> screenList = new ArrayList<>();
    public static final PendentScreen ps = new PendentScreen();

    @Override
    public void start(Stage stage) throws IOException {
        getPS();

        getStage2(stage);

        List<String> list = new ArrayList<>();

        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 640);
        stage.setResizable(false);
        stage.setTitle("Fill The Dish!");
        stage.setScene(scene);
        stage.show();

        list.add("Home.fxml");
        addToList(list);
    }


    private static void addToList(List<String> list){
        screenList = list;
    }


    public static PendentScreen getPS() {
        return ps;
    }

    public void setNewScene(String newFXML) throws IOException {
        Parent newPane = FXMLLoader.load(getClass().getResource(newFXML));
        stg.getScene().setRoot(newPane);
    }

    private static void getStage2(Stage stage){
        stg = stage;

    }
    public static List<String> getList() {
        return screenList;
    }

    public static void main(String[] args) {
        launch();
    }
}