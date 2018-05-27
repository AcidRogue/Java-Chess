package Pieces;

import Main.Main;
import Main.Space;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    private boolean isFirst = true;

    public Pawn(String side) {
        super("pawn", side);
    }

    @Override
    public boolean move(Space destination) {
        if(!super.check(destination)){
            return false;
        }
        this.getSpace().removePiece();
        destination.putPiece(this);

        isFirst = false;
        return true;
    }

    @Override
    public List<Space> getSpaces(int x, int y){
        List<Space> result = new ArrayList<>();

        if (this.getSide().equals("white")) {
            result.add(Main.spaces[x][y - 1]);
            if (Main.spaces[x - 1][y - 1].isTaken() && Main.spaces[x - 1][y - 1].getPiece().getSide().equals("black")) {
                result.add(Main.spaces[x - 1][y - 1]);
            }
            if (Main.spaces[x + 1][y - 1].isTaken() && Main.spaces[x + 1][y - 1].getPiece().getSide().equals("black")) {
                result.add(Main.spaces[x + 1][y - 1]);
            }
            if(isFirst){
                result.add(Main.spaces[x][y - 2]);
            }
        } else {
            result.add(Main.spaces[x][y + 1]);
            if (Main.spaces[x - 1][y + 1].isTaken() && Main.spaces[x - 1][y + 1].getPiece().getSide().equals("white")) {
                result.add(Main.spaces[x - 1][y + 1]);
            }
            if (Main.spaces[x + 1][y + 1].isTaken() && Main.spaces[x + 1][y + 1].getPiece().getSide().equals("white")) {
                result.add(Main.spaces[x + 1][y + 1]);
            }
            if(isFirst){
                result.add(Main.spaces[x][y + 2]);
            }
        }

        return result;
    }
}
