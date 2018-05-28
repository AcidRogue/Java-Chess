package Pieces;

import Main.Main;
import Main.Space;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece{
    public Rook(String side) {
        super("rook", side);
    }

    @Override
    public boolean move(Space destination) {
        if(super.move(destination)){
            return true;
        }
        return false;
    }


    @Override
    public List<Space> getSpaces(int x, int y){
        List<Space> result = new ArrayList<>();

        //Horizontal spaces
        for (int i = x - 1; i >= 0; i--) {
            result.add(Main.spaces[i][y]);
            if (Main.spaces[i][y].isTaken()) {
                break;
            }
        }
        for (int i = x + 1; i < 8 ; i++) {
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
        for (int i = y + 1; i < 8 ; i++) {
            result.add(Main.spaces[x][i]);
            if (Main.spaces[x][i].isTaken()) {
                break;
            }
        }

        super.check(result);

        return result;
    }
}
