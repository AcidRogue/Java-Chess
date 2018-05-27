package Pieces;

import Main.Main;
import Main.Space;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece{
    public King(String side) {
        super("king", side);
    }

    @Override
    public List<Space> getSpaces(int x, int y){
        List<Space> result = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(Math.abs(i - x) <= 1 && Math.abs(j - y) <= 1){
                    result.add(Main.spaces[i][j]);
                }
            }
        }

        return result;
    }

}
