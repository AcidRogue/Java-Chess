package Pieces;

import Main.Main;
import Main.Space;

import java.util.List;

public class Piece {
    private Space space;
    private String side;
    private String name;

    public Piece(String name, String side){
        this.name = name;
        this.side = side;
    }

    public boolean move(Space destination) {
        if(!check(destination)){
            return false;
        }
        if(destination.isTaken()){
            if(this.getSide().equals(destination.getPiece().getSide())){
                return false;
            }
            else{
                destination.removePiece();
            }
        }

        this.getSpace().removePiece();
        destination.putPiece(this);

        return true;
    }

    public boolean check(Space destination){
        if (this.space == destination) {
            System.out.println("same");
            return false;
        }

        int x = this.getSpace().getX();
        int y = this.getSpace().getY();

        List<Space> result = getSpaces(x, y);

        for (int i = 0; i < result.size(); i++) {
            if (destination == result.get(i)) {
                return true;
            }
        }
        return false;
    }

    public List<Space> getSpaces(int x, int y) {
        return null;
    }

    public void setSpace(Space space){
        this.space = space;
    }

    public Space getSpace() {
        return space;
    }

    public String getName(){
        return name;
    }

    public String getSide(){
        return side;
    }
}
