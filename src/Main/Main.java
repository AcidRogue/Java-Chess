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
        new Rook(spaces[0][0], "black");
        new Knight(spaces[1][0], "black");
        new Bishop(spaces[2][0], "black");
        new Queen(spaces[3][0], "black");
        new King(spaces[4][0], "black");
        new Bishop(spaces[5][0], "black");
        new Knight(spaces[6][0], "black");
        new Rook(spaces[7][0], "black");
        for (int i = 0; i < 8; i++) {
            new Pawn(spaces[i][1], "black");
        }

        new Rook(spaces[0][7], "white");
        new Knight(spaces[1][7], "white");
        new Bishop(spaces[2][7], "white");
        new Queen(spaces[3][7], "white");
        new King(spaces[4][7], "white");
        new Bishop(spaces[5][7], "white");
        new Knight(spaces[6][7], "white");
        new Rook(spaces[7][7], "white");
        for (int i = 0; i < 8; i++) {
            new Pawn(spaces[i][6], "white");
        }
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
                            for (int k = 0; k < allowedSpaces.size(); k++) {
                                allowedSpaces.get(k).getHBox().setStyle(styles.get(k));
                            }
                            if(currentPlayer.equals(playerWhite)){
                                currentPlayer = playerBlack;
                            }
                            else{
                                currentPlayer = playerWhite;
                            }
                        }
                        toMove = null;
                        pressed = false;
                        allowedSpaces = new ArrayList<>();
                        styles = new ArrayList<>();
                    }
                    else{
                        if (s.isTaken()) {
                            pressed = true;
                            toMove = p;
                            allowedSpaces = toMove.getSpaces(toMove.getSpace().getX(), toMove.getSpace().getY());
                            for (int k = 0; k < allowedSpaces.size(); k++) {
                                styles.add(allowedSpaces.get(k).getHBox().getStyle());
                                if(allowedSpaces.get(k).isTaken()){
                                    allowedSpaces.get(k).getHBox().setStyle("-fx-background-color: #ff2020");
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
