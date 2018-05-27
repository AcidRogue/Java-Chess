package Pieces;

import Main.Space;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
    public Queen(Space space, String side) {
        super(space, "queen", side);
    }

    @Override
    public boolean move(Space destination) {
        if (!check(destination)) {
            return false;
        }
        if (destination.isTaken()) {
            if (this.getSide().equals(destination.getPiece().getSide())) {
                return false;
            }
            destination.removePiece();
        }
        new Queen(destination, getSide());
        this.getSpace().removePiece();
        return true;
    }

    @Override
    public List<Space> getSpaces(int x, int y) {
        List<Space> result = new ArrayList<>();

        result.addAll(new Rook().getSpaces(x,y));
        result.addAll(new Bishop().getSpaces(x, y));

        return result;
    }
}
