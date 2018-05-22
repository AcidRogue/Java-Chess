package Pieces;

import Main.Space;

public class Piece {
    private Space space;
    private String side;
    private String name;

    public Piece(Space space, String name,  String side){
        this.name = name;
        this.space = space;
        this.side = side;

        space.putPiece(this);
    }

    public void move(Space destination){

    }

    public Space getSpace() {
        return space;
    }

    public String getName(){
        return name;
    }

    public String getSide(){
        return side;
    }
}
