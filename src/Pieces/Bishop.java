package Pieces;

import Main.Space;

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

        if(desX - x == desY - y){
            return true;
        }
        return false;
    }
}
