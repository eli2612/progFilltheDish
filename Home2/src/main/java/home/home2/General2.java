package home.home2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class General2 {

    private  static boolean loginState2 = false;
    private static List<String> list = new ArrayList<>();

    private General2(){}

    public static void setLoginStateSview(Boolean login){
        loginState2 = login;
    }

    public static Boolean getLoginStateSView(){
        return loginState2;
    }

    public static String setSource(String newScreen) {
        String tempSrc = newScreen;
        tempSrc += ".fxml";
        return tempSrc;
    }

    public static void changeScene(String newSource) throws IOException {

        Home2 m = new Home2();
        list = Home2.getList();
        list.add(newSource);

        m.setNewScene(newSource);
    }


    public static void setBackScene() throws IOException {
        Home2 m = new Home2();
        String newScene;

        list = Home2.getList();
        if (list.size() > 1) {
            newScene = list.get(list.size() - 2);
            m.setNewScene(newScene);

            if (newScene.equals("Home")) {
                list.clear();
            } else {
                list.remove(list.size()-1);
            }


        }
    }

}
