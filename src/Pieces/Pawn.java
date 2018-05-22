package Pieces;

import Main.Space;

public class Pawn extends Piece{
    public Pawn(Space space, String side) {
        super(space, "pawn", side);
    }

    @Override
    public void move(Space destination) {
        int desX = destination.getX();
        int desY = destination.getY();
        if(this.getSpace().getX() == desX && this.getSpace().getY() == desY){
            return;
        }
        if(destination.isTaken()){
            if(this.getSide().equals(destination.getPiece().getSide())){
                return;
            }
            destination.removePiece();
        }
        new Pawn(destination, getSide());
        this.getSpace().removePiece();
    }
}
