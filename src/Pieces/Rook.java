package Pieces;

import Main.Main;
import Main.Space;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece{
    public Rook(Space space, String side) {
        super(space, "rook", side);
    }
    public Rook(){
        super();
    }

    @Override
    public boolean move(Space destination) {
        if(!check(destination)){
            return false;
        }
        if(destination.isTaken()){
            if(this.getSide().equals(destination.getPiece().getSide())){
                return false;
            }
            destination.removePiece();
        }
        new Rook(destination, getSide());
        this.getSpace().removePiece();
        return true;
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

        return result;
    }
}
