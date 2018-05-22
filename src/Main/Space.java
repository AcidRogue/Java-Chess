package Main;

import Pieces.Piece;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class Space {
    private HBox hBox;
    private boolean taken;
    private int x;
    private int y;

    private ImageView iv;

    private Piece piece;

    public Space(HBox hBox, int x, int y) {
        this.x = x;
        this.y = y;
        this.hBox = hBox;
        taken = false;
    }

    public void putPiece(String name) {
        this.piece = new Piece(this, name);
        iv = new ImageView("/Sprites/" + name + ".png");

        setTaken(true);
        setImage(iv);
    }

    public Piece getPiece() {
        return piece;
    }

    public void setImage(ImageView iv) {
        hBox.getChildren().add(iv);
    }

    public void removeImage() {
        hBox.getChildren().remove(0);
        piece = null;
        setTaken(false);
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public boolean isTaken() {
        return taken;
    }

    public HBox getHBox() {
        return hBox;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
