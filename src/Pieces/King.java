package Pieces;

import Main.Main;
import Main.Space;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece{
    private boolean castled = false;
    private Space castleSpace;
    private Rook rookToCastle;

    public King(String side) {
        super("king", side);
        if(side.equals("white")){
            castleSpace = Main.spaces[6][7];
            rookToCastle = (Rook)Main.spaces[7][7].getPiece();
        }
        else {
            castleSpace = Main.spaces[6][0];
            rookToCastle = (Rook) Main.spaces[7][0].getPiece();
        }
    }

    @Override
    public boolean move(Space destination) {
        if(super.move(destination)){
            if(destination == castleSpace){
                castled = true;
            }
            return true;
        }
        return false;
    }

    @Override
    public List<Space> getSpaces(int x, int y){
        List<Space> result = new ArrayList<>();

        if(!castleSpace.isTaken() && !this.moved() && !castled && !rookToCastle.moved()){
            result.add(castleSpace);
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(Math.abs(i - x) <= 1 && Math.abs(j - y) <= 1){
                    result.add(Main.spaces[i][j]);
                }
            }
        }

        super.check(result);

        return result;
    }

}
