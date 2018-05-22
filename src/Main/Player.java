package Main;

import Pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int wins = 0;
    private List<Piece> pieces;
    private List<Piece> piecesTaken;

    private String side;

    public Player(String side){
        this.side = side;

        pieces = new ArrayList<>(16);
        piecesTaken = new ArrayList<>();
    }

    public void addPiece(Piece p){
        if(p.getSide().equals(side)){
            pieces.add(p);
        }
    }

    public void removePiece(Piece p){
        if(p.getSide().equals(side)){
            pieces.remove(p);
        }
    }

    public String getSide(){
        return side;
    }


}
