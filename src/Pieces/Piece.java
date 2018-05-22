package Pieces;

import Main.Space;
public class Piece {
    private Space space;
    private String side;
    private String name;

    private int x;
    private int y;

    public Piece(Space space, String name){
        this.space = space;
        this.side = name.substring(0, 5);
        this.name = name;

        this.x = space.getX();
        this.y = space.getY();
    }

    public void move(Space destination){
        int desX = destination.getX();
        int desY = destination.getY();
        if(x == desX && y == desY){
            return;
        }
        if(destination.isTaken()){
            if(this.side.equals(destination.getPiece().side)){
                return;
            }
            destination.removeImage();
        }
        destination.putPiece(name);
        space.removeImage();
    }
}
