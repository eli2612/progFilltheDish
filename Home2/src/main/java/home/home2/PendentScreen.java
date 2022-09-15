package home.home2;


import javafx.scene.image.Image;

public class PendentScreen {
    private String scr;
    private String label;
    String name;
    Image image;
    String type;
    String description;
    String fxml;

    public PendentScreen() {
        scr = "";
    }

    public String get() {
        String next = scr;
        scr = "";
        return next;
    }

    public void add(String pendentScreen) {
        scr = pendentScreen;
    }

    public Boolean isNull() {
        return scr.equals("");
    }

    public void clear() {
        scr = "";
    }

    public String getLabel(){
        return label;
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

    public void setImage(Image immagine){
        this.image = immagine;
    }

    public Image getImage(){
        return image;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setScreen(String fxml){
        this.fxml = fxml;
    }

    public String getScreen(){
        return fxml;
    }

}
