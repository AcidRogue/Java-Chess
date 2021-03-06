package Pieces;

import Main.Main;
import Main.Space;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    public Pawn(String side) {
        super("pawn", side);
    }

    @Override
    public List<Space> getSpaces(int x, int y) {
        List<Space> result = new ArrayList<>();

        if (this.getSide().equals("white")) {
            if(!Main.spaces[x][y - 1].isTaken()){
                result.add(Main.spaces[x][y - 1]);
            }
            if (x - 1 >= 0 && y - 1 >= 0 && Main.spaces[x - 1][y - 1].isTaken() && Main.spaces[x - 1][y - 1].getPiece().getSide().equals("black")) {
                result.add(Main.spaces[x - 1][y - 1]);
            }
            if (x + 1 < 8 && y - 1 >= 0 && Main.spaces[x + 1][y - 1].isTaken() && Main.spaces[x + 1][y - 1].getPiece().getSide().equals("black")) {
                result.add(Main.spaces[x + 1][y - 1]);
            }
            if (!moved() && !Main.spaces[x][y - 2].isTaken()) {
                result.add(Main.spaces[x][y - 2]);
            }
        } else {
            if(!Main.spaces[x][y + 1].isTaken()){
                result.add(Main.spaces[x][y + 1]);
            }
            if (x - 1 >= 0 && y + 1 < 8 && Main.spaces[x - 1][y + 1].isTaken() && Main.spaces[x - 1][y + 1].getPiece().getSide().equals("white")) {
                result.add(Main.spaces[x - 1][y + 1]);
            }
            if (x + 1 < 8 && y + 1 < 8 && Main.spaces[x + 1][y + 1].isTaken() && Main.spaces[x + 1][y + 1].getPiece().getSide().equals("white")) {
                result.add(Main.spaces[x + 1][y + 1]);
            }
            if (!moved() && !Main.spaces[x][y + 2].isTaken()) {
                result.add(Main.spaces[x][y + 2]);
            }
        }

        super.check(result);

        return result;
    }
}
