package Pieces;

import Main.Space;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {
    public Bishop(Space space, String side) {
        super(space, "bishop", side);
    }

    @Override
    public boolean move(Space destination) {
        if(!check(destination)){
            return false;
        }
        if(destination.isTaken()){
            if(this.getSide().equals(destination.getPiece().getSide())){
                return false;
            }
            destination.removePiece();
        }
        new Bishop(destination, getSide());
        this.getSpace().removePiece();
        return true;
    }

    @Override
    public boolean check(Space destination){
        if(!super.check(destination)){
            return false;
        }

        int x = this.getSpace().getX();
        int y = this.getSpace().getY();
        int desX = destination.getX();
        int desY = destination.getY();

        if(Math.abs(x - desX) == Math.abs(y - desY)){
            return true;
        }
        return false;
    }

    @Override
    public List<Space> getSpaces(int x, int y){
        List<Space> result = new ArrayList<>();

        return result;
    }
}
