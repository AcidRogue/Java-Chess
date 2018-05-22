package Pieces;

import Main.Space;

public class Knight extends Piece{
    public Knight(Space space, String side) {
        super(space, "knight", side);
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
        new Knight(destination, getSide());
        this.getSpace().removePiece();
    }
}
