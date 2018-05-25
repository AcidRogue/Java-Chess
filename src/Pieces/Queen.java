package Pieces;

import Main.Space;

public class Queen extends Piece{
    public Queen(Space space, String side) {
        super(space, "queen", side);
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
        new Queen(destination, getSide());
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

        if(x == desX || y == desY){
            return true;
        }
        if(Math.abs(x - desX) == Math.abs(y - desY)){
            return true;
        }

        return false;
    }
}
