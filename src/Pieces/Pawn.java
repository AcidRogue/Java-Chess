package Pieces;

import Main.Main;
import Main.Space;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    private boolean isFirst;

    public Pawn(Space space, String side, boolean isFirst) {
        super(space, "pawn", side);
        this.isFirst = isFirst;
    }

    @Override
    public boolean move(Space destination) {
        if (!check(destination)) {
            return false;
        }
        new Pawn(destination, getSide(), false);
        this.getSpace().removePiece();
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
