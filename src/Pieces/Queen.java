package Pieces;

import Main.Main;
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
    public boolean check(Space destination) {
        return super.check(destination);
    }

    @Override
    public List<Space> getSpaces(int x, int y) {
        List<Space> result = new ArrayList<>();

        //Horizontal spaces
        for (int i = x - 1; i >= 0; i--) {
            result.add(Main.spaces[i][y]);
            if (Main.spaces[i][y].isTaken()) {
                break;
            }
        }
        for (int i = x + 1; i < 8; i++) {
            result.add(Main.spaces[i][y]);
            if (Main.spaces[i][y].isTaken()) {
                break;
            }
        }

        //Vertical spaces
        for (int i = y - 1; i >= 0; i--) {
            result.add(Main.spaces[x][i]);
            if (Main.spaces[x][i].isTaken()) {
                break;
            }
        }
        for (int i = y + 1; i < 8; i++) {
            result.add(Main.spaces[x][i]);
            if (Main.spaces[x][i].isTaken()) {
                break;
            }
        }

        //Diagonal spaces
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
