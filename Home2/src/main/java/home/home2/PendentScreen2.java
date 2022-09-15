package home.home2;


import javafx.scene.image.Image;

public class PendentScreen2 {
    private String screen;
    String description;

    Image image;
    private String label;

    String type;
    String name;
    String xmlFile;

    public PendentScreen2() {
        screen = "";
    }

    public String get() {
        String next = screen;
        screen = "";
        return next;
    }
    public void setScreen2(String fxml){
        this.xmlFile = fxml;
    }



    public Boolean isNull() {
        return screen.equals("");
    }

    public void clear() {
        screen = "";
    }

    public void add(String pendentScreen) {
        screen = pendentScreen;
    }


    public void setLabel(String label){
        this.label = label;
    }

    public void setName(String nome){
        this.name = nome;
    }

    public String getName(){
        return name;

    }
    public String getLabel(){
        return label;
    }

    public Image getImage(){
        return image;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setImage(Image immagine){
        this.image = immagine;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public String getType(){
        return type;
    }

    public String getScreen2(){
        return xmlFile;
    }

}
