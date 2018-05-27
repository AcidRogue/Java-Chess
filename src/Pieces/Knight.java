package Pieces;

import Main.Main;
import Main.Space;

import java.util.ArrayList;
import java.util.List;

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
    public List<Space> getSpaces(int x, int y){
        List<Space> result = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Math.abs(i - x) == 2 && Math.abs(j -y) == 1 || Math.abs(i - x) == 1 && Math.abs(j - y) == 2) {
                    result.add(Main.spaces[i][j]);
                }
            }
        }

        return result;
    }
}
