package Main;

import Pieces.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    private double canvasWidth = 600;
    private double canvasHeight = 600;

    public static Space[][] spaces;

    public static GridPane gridPane;

    public static Player playerWhite;
    public static Player playerBlack;
    private Player currentPlayer;

    @Override
    public void start(Stage primaryStage) throws Exception {
        spaces = new Space[8][8];

        playerWhite = new Player("white");
        playerBlack = new Player("black");
        currentPlayer = playerWhite;

        Parent root = createGridPane();
        placePieces();
        handleOnClick();
        primaryStage.setTitle("Chess");
        primaryStage.setScene(new Scene(root, canvasWidth, canvasHeight));
        primaryStage.show();
    }

    void placePieces() {
        //spaces[0][0].putPiece(new Rook("black"));
        //spaces[1][0].putPiece(new Knight("black"));
        //spaces[2][0].putPiece(new Bishop("black"));
        //spaces[3][0].putPiece(new Queen("black"));
        //spaces[5][0].putPiece(new Bishop("black"));
        //spaces[6][0].putPiece(new Knight("black"));
        spaces[7][0].putPiece(new Rook("black"));
        spaces[4][0].putPiece(new King("black"));
        //for (int i = 0; i < 8; i++) {
        //    spaces[i][1].putPiece(new Pawn("black"));
        //}

        //spaces[0][7].putPiece(new Rook("white"));
        //spaces[1][7].putPiece(new Knight("white"));
        //spaces[2][7].putPiece(new Bishop("white"));
        //spaces[3][7].putPiece(new Queen("white"));
        //spaces[5][7].putPiece(new Bishop("white"));
        //spaces[6][7].putPiece(new Knight("white"));
        spaces[7][7].putPiece(new Rook("white"));
        spaces[4][7].putPiece(new King("white"));
        //for (int i = 0; i < 8; i++) {
        //    spaces[i][6].putPiece(new Pawn( "white"));
        //}
    }

    private GridPane createGridPane() {
        gridPane = new GridPane();
        gridPane.setPrefSize(canvasWidth, canvasHeight);

        int counter = 0;

        for (int i = 0; i < 8; i++) {
            ColumnConstraints column = new ColumnConstraints(75);
            gridPane.getColumnConstraints().add(column);
            counter++;
            for (int j = 0; j < 8; j++) {
                RowConstraints row = new RowConstraints(75);
                gridPane.getRowConstraints().add(row);

                HBox hBox = new HBox();

                if (counter % 2 != 0) {
                    hBox.setStyle("-fx-background-color: #444444");
                }

                hBox.setAlignment(Pos.CENTER);

                spaces[i][j] = new Space(hBox, i, j);

                gridPane.add(spaces[i][j].getHBox(), i, j);

                counter++;
            }
        }

        gridPane.setGridLinesVisible(true);

        return gridPane;
    }

    private boolean pressed = false;
    private Piece toMove = null;

    private List<String> styles = new ArrayList<>();
    private List<Space> allowedSpaces = new ArrayList<>();

    private String style = "";
    private Space temp = null;

    private void handleOnClick() {
        for (int i = 0; i < spaces.length; i++) {
            for (int j = 0; j < spaces[i].length; j++) {
                Space s = spaces[i][j];

                s.getHBox().setOnMousePressed(e -> {
                    Piece p = s.getPiece();

                    if(!pressed && p == null){
                        return;
                    }

                    if(!pressed && !p.getSide().equals(currentPlayer.getSide())){
                        return;
                    }

                    if(pressed){
                        if(toMove.move(s)){
                            if(currentPlayer.equals(playerWhite)){
                                currentPlayer = playerBlack;
                            }
                            else{
                                currentPlayer = playerWhite;
                            }
                        }
                        for (int k = 0; k < allowedSpaces.size(); k++) {
                            allowedSpaces.get(k).getHBox().setStyle(styles.get(k));
                        }

                        temp.getHBox().setStyle(style);
                        toMove = null;
                        pressed = false;
                        allowedSpaces = new ArrayList<>();
                        styles = new ArrayList<>();
                    }
                    else{
                        if (s.isTaken()) {
                            allowedSpaces = p.getSpaces(p.getSpace().getX(), p.getSpace().getY());
                            if(allowedSpaces.size() == 0){
                                allowedSpaces = new ArrayList<>();
                                return;
                            }
                            temp = s;
                            toMove = p;
                            pressed = true;
                            style = temp.getHBox().getStyle();
                            temp.getHBox().setStyle("-fx-background-color: #9ddd3e");

                            for (int k = 0; k < allowedSpaces.size(); k++) {
                                styles.add(allowedSpaces.get(k).getHBox().getStyle());
                                if(allowedSpaces.get(k).isTaken()){
                                    if(!allowedSpaces.get(k).getPiece().getSide().equals(toMove.getSide())){
                                        allowedSpaces.get(k).getHBox().setStyle("-fx-background-color: #ff2020");
                                    }
                                }
                                else{
                                    allowedSpaces.get(k).getHBox().setStyle("-fx-background-color: #8bff56");
                                }
                            }
                        }
                    }

                });
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
