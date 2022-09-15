package home.home2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Home2 extends Application {

    private static Stage stg;
    private static List<String> screenList;
    public static final PendentScreen2 ps = new PendentScreen2();

    @Override
    public void start(Stage stage) throws Exception {
        getStage(stage);

        List<String> list = new ArrayList<>();
        list.add("Home2.fxml");
        addToList(list);

        getPS2();


        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("Home2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 640);
        stage.setResizable(false);
        stage.setTitle("Fill The Dish!");
        stage.setScene(scene);
        stage.show();
    }

    private static void getStage(Stage stage){
        stg = stage;

    }
    private static void addToList(List<String> list){
        screenList = list;
    }

    public static List<String> getList() {
        return screenList;
    }
    public static PendentScreen2 getPS2() {
        return ps;
    }

    public void setNewScene(String newFXML) throws IOException {
        Parent newPane = FXMLLoader.load(getClass().getResource(newFXML));
        stg.getScene().setRoot(newPane);
    }

    public static void main(String[] args) {
        launch();
    }
}
