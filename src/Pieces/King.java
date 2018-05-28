package Pieces;

import Main.Main;
import Main.Space;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece{
    private boolean castled = false;
    private Space castleSpace;
    private Rook rookToCastle;
    private Space placeForRook;

    public King(String side) {
        super("king", side);
    }

    private void initialize(){
        int x = this.getSpace().getX();
        int y = this.getSpace().getY();
        castleSpace = Main.spaces[x + 2][y];
        rookToCastle = (Rook)Main.spaces[x + 3][y].getPiece();
        placeForRook = Main.spaces[x + 1][y];
    }

    @Override
    public boolean move(Space destination) {
        if(super.move(destination)){
            if(destination == castleSpace){
                rookToCastle.moveTo(placeForRook);
                castled = true;
            }
            return true;
        }
        return false;
    }

    @Override
    public List<Space> getSpaces(int x, int y){
        if(!moved()){
            initialize();
        }

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
