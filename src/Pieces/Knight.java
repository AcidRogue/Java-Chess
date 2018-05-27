package Pieces;

import Main.Space;

public class Knight extends Piece{
    public Knight(Space space, String side) {
        super(space, "knight", side);
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
        new Knight(destination, getSide());
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

        if(desX != x + 2 && desX != x - 2 && desY != y - 2 && desY != y + 2){
            return false;
        }
        return true;
    }
}
