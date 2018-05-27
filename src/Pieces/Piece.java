package Pieces;

import Main.Space;

import java.util.List;

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

    public boolean move(Space destination){
        return false;
    }

    public boolean check(Space destination){
        return this.space != destination;
    }

    public List<Space> getSpaces(int x, int y) {
        return null;
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
