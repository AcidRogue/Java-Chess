package Pieces;

import Main.Main;
import Main.Space;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {
    public Bishop(String side) {
        super("bishop", side);
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
