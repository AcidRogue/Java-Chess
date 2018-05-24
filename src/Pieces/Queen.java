package Pieces;

import Main.Space;

public class Queen extends Piece{
    public Queen(Space space, String side) {
        super(space, "queen", side);
    }

    @Override
    public boolean move(Space destination) {
        int desX = destination.getX();
        int desY = destination.getY();
        if(this.getSpace().getX() == desX && this.getSpace().getY() == desY){
            return false;
        }
        if(destination.isTaken()){
            if(this.getSide().equals(destination.getPiece().getSide())){
                return false;
            }
            destination.removePiece();
        }
        new Queen(destination, getSide());
        this.getSpace().removePiece();
        return true;
    }
}
