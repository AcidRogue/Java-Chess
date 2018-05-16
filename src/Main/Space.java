package Main;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

import java.awt.*;

public class Space {
    private int x;
    private int y;
    private HBox hBox;
    private boolean taken;

    public Space(int x, int y){
        this.x = x;
        this.y = y;
        hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        taken = false;
    }

    public void setImage(ImageView iv){
        hBox.getChildren().add(iv);
    }

    public void setTaken(boolean taken){
        this.taken = taken;
    }
    public boolean getTaken(){
        return this.taken;
    }

    public void setStyle(boolean white){
        if(!white){
            hBox.setStyle("-fx-background-color: #444444");
        }
    }

    public HBox getHBox(){
        return this.hBox;
    }

    public List<Space> getAvailable(){
        List<Space> available = new ArrayList<>();



        return available;
    }



    public Point getPoints(){
        return new Point(x, y);
    }
}
