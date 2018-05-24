package Main;

import Pieces.Piece;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class Space {
    private HBox hBox;
    private boolean taken;
    private int x;
    private int y;

    private Piece piece;

    public Space(HBox hBox, int x, int y) {
        this.x = x;
        this.y = y;
        this.hBox = hBox;
        piece = null;
        taken = false;
    }

    public void putPiece(Piece p) {
        ImageView iv = new ImageView("/Sprites/" + p.getSide() + "_" + p.getName() + ".png");

        taken = true;
        hBox.getChildren().add(iv);

        this.piece = p;

        if(piece.getSide().equals("white")){
            Main.playerWhite.addPiece(piece);
        }
        else{
            Main.playerBlack.addPiece(piece);
        }
    }

    public void removePiece() {
        hBox.getChildren().remove(0);
        if(piece.getSide().equals("white")){
            Main.playerWhite.removePiece(piece);
        }
        else{
            Main.playerBlack.removePiece(piece);
        }
        piece = null;
        taken = false;
    }

    public Piece getPiece() {
        return piece;
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
