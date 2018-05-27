package Pieces;

import Main.Main;
import Main.Space;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    private boolean isFirst = true;

    public Pawn(Space space, String side) {
        super(space, "pawn", side);
    }

    @Override
    public boolean move(Space destination) {
        if (!check(destination)) {
            return false;
        }
        new Pawn(destination, getSide());
        this.getSpace().removePiece();
        isFirst = false;
        return true;
    }

    @Override
    public boolean check(Space destination) {
        if (!super.check(destination)) {
            return false;
        }

        int x = this.getSpace().getX();
        int y = this.getSpace().getY();
        int desX = destination.getX();
        int desY = destination.getY();

        List<Space> result = getSpaces(x, y);

        for (int i = 0; i < result.size(); i++) {
            if(destination == result.get(i)){
                if(result.get(i).isTaken()){
                    result.get(i).removePiece();
                }
                return true;
            }
        }

        return false;
    }

    @Override
    public List<Space> getSpaces(int x, int y){
        List<Space> result = new ArrayList<>();

        if (this.getSide().equals("white")) {
            if (Main.spaces[x - 1][y - 1].isTaken() && Main.spaces[x - 1][y - 1].getPiece().getSide().equals("black")) {
                result.add(Main.spaces[x - 1][y - 1]);
            }
            if (Main.spaces[x + 1][y - 1].isTaken() && Main.spaces[x + 1][y - 1].getPiece().getSide().equals("black")) {
                result.add(Main.spaces[x + 1][y - 1]);
            }
            if(isFirst){
                result.add(Main.spaces[x][y - 1]);
                result.add(Main.spaces[x][y - 2]);
            }
        } else {
            if (Main.spaces[x - 1][y + 1].isTaken() && Main.spaces[x - 1][y + 1].getPiece().getSide().equals("white")) {
                result.add(Main.spaces[x - 1][y + 1]);
            }
            if (Main.spaces[x + 1][y + 1].isTaken() && Main.spaces[x + 1][y + 1].getPiece().getSide().equals("white")) {
                result.add(Main.spaces[x + 1][y + 1]);
            }
            if(isFirst){
                result.add(Main.spaces[x][y + 1]);
                result.add(Main.spaces[x][y + 2]);
            }
        }

        return result;
    }
}
