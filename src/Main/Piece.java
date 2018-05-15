package Main;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class Piece {
    public Piece(String name, int pos){
        ImageView iv = new ImageView("/Sprites/" + name + ".png");
        ((HBox)Main.gridPane.getChildren().get(pos)).getChildren().add(iv);
    }
}
