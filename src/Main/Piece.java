package Main;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class Piece {
    public Piece(String name, int x, int y){
        ImageView iv = new ImageView("/Sprites/" + name + ".png");

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(i == x && j == y){
                    Main.spaces[i][j].setTaken(true);
                    Main.spaces[i][j].setImage(iv);
                }
            }
        }
    }


}
