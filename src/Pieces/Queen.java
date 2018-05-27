package Pieces;

import Main.Space;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
    private Rook rook;
    private Bishop bishop;

    public Queen(String side) {
        super("queen", side);
        rook = new Rook(side);
        bishop = new Bishop(side);
    }

    @Override
    public List<Space> getSpaces(int x, int y) {
        List<Space> result = new ArrayList<>();

        result.addAll(rook.getSpaces(x,y));
        result.addAll(bishop.getSpaces(x, y));

        return result;
    }
}
