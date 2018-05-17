package Main;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class Space {
    private HBox hBox;
    private boolean taken;
    private int x;
    private int y;
    private String name;
    private ImageView iv;

    public Space(HBox hBox, int x, int y) {
        this.x = x;
        this.y = y;
        this.hBox = hBox;
        taken = false;
    }

    public void putPiece(String name){
        this.name = name;
        iv = new ImageView("/Sprites/" + name + ".png");

        setTaken(true);
        setImage(iv);
    }

    public void setImage(ImageView iv) {
        hBox.getChildren().add(iv);
    }

    public void removeImage(){
        hBox.getChildren().remove(0);
        this.taken = false;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public boolean isTaken() {
        return this.taken;
    }

    public HBox getHBox() {
        return this.hBox;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public void move(int desX, int desY) {
        Main.spaces[desX][desY].putPiece(this.name);
        Main.spaces[desX][desY].setTaken(true);
        removeImage();
    }
}
