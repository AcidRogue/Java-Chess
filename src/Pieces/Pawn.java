package Pieces;

import Main.Space;

public class Pawn extends Piece{
    private boolean isFirst = true;

    public Pawn(Space space, String side) {
        super(space, "pawn", side);
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
        new Pawn(destination, getSide());
        this.getSpace().removePiece();
        isFirst = false;
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

        if(!(x == desX)){
            return false;
        }
        if(this.getSide().equals("white")){
            return (isFirst)? desY == y - 1 || desY == y - 2 : desY == y - 1;
        }
        else{
            return (isFirst)? desY == y + 1 || desY == y + 2 : desY == y + 1;
        }
    }
}
