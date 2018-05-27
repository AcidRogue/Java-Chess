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
        if(this.space == destination){
            return false;
        }

        int x = this.getSpace().getX();
        int y = this.getSpace().getY();

        List<Space> result = getSpaces(x, y);

        for (int i = 0; i < result.size(); i++) {
            if(destination == result.get(i)){
                if(result.get(i).isTaken()){
                    if(result.get(i).getPiece().getSide().equals(destination.getPiece().getSide())){
                        destination.removePiece();
                        return true;
                    }
                    return false;
                }
                return true;
            }
        }

        return false;
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
