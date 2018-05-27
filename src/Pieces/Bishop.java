package Pieces;

import Main.Main;
import Main.Space;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {
    public Bishop(Space space, String side) {
        super(space, "bishop", side);
    }
    public Bishop(){
        super();
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
    public List<Space> getSpaces(int x, int y){
        List<Space> result = new ArrayList<>();

        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            result.add(Main.spaces[i][j]);
            if (Main.spaces[i][j].isTaken()) {
                break;
            }
        }
        for (int i = x + 1, j = y + 1; i < 8 && j < 8; i++, j++) {
            result.add(Main.spaces[i][j]);
            if (Main.spaces[i][j].isTaken()) {
                break;
            }
        }

        for (int i = x - 1, j = y + 1; i >= 0 && j < 8; i--, j++) {
            result.add(Main.spaces[i][j]);
            if (Main.spaces[i][j].isTaken()) {
                break;
            }
        }
        for (int i = x + 1, j = y - 1; i < 8 && j >= 0; i++, j--) {
            result.add(Main.spaces[i][j]);
            if (Main.spaces[i][j].isTaken()) {
                break;
            }
        }

        return result;
    }
}
