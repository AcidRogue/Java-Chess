package Pieces;

import Main.Main;
import Main.Space;

import java.util.List;

public class Piece {
    private Space space;
    private String side;
    private String name;
    private boolean moved = false;

    public Piece(String name, String side){
        this.name = name;
        this.side = side;
    }

    public boolean move(Space destination) {
        if(!check(destination)){
            return false;
        }
        if(destination.isTaken()){
            if(this.getSide().equals(destination.getPiece().getSide())){
                return false;
            }
            else{
                destination.removePiece();
            }
        }

        this.moved = true;

        this.getSpace().removePiece();
        destination.putPiece(this);

        return true;
    }

    public boolean check(Space destination){
        int x = this.getSpace().getX();
        int y = this.getSpace().getY();

        List<Space> result = getSpaces(x, y);

        for (int i = 0; i < result.size(); i++) {
            if (destination == result.get(i)) {
                return true;
            }
        }
        return false;
    }

    public boolean moved(){
        return moved;
    }

    public List<Space> getSpaces(int x, int y) {
        return null;
    }

    //Checks if the allowed spaces contain the current spaces or the destination piece is the same type. If yes, the method removes those allowed spaces.
    public void check(List<Space> result){
        result.removeIf(a -> a == this.getSpace() || a.getPiece() != null && a.getPiece().getSide().equals(this.getSide()));
    }

    public void setSpace(Space space){
        this.space = space;
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
