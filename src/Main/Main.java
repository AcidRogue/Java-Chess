package Main;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    private double canvasWidth = 600;
    private double canvasHeight = 600;

    public static Space[][] spaces;

    public static GridPane gridPane;

    @Override
    public void start(Stage primaryStage) throws Exception {
        spaces = new Space[8][8];

        Parent root = createGridPane();
        placePieces();
        handleOnClick();
        primaryStage.setTitle("Chess");
        primaryStage.setScene(new Scene(root, canvasWidth, canvasHeight));
        primaryStage.show();
    }

    void placePieces() {
        spaces[0][0].putPiece("black_rook");
        spaces[1][0].putPiece("black_knight");
        spaces[2][0].putPiece("black_bishop");
        spaces[3][0].putPiece("black_queen");
        spaces[4][0].putPiece("black_king");
        spaces[5][0].putPiece("black_bishop");
        spaces[6][0].putPiece("black_knight");
        spaces[7][0].putPiece("black_rook");
        for (int i = 0; i < 8; i++) {
            spaces[i][1].putPiece("black_pawn");
        }

        spaces[0][7].putPiece("white_rook");
        spaces[1][7].putPiece("white_knight");
        spaces[2][7].putPiece("white_bishop");
        spaces[3][7].putPiece("white_queen");
        spaces[4][7].putPiece("white_king");
        spaces[5][7].putPiece("white_bishop");
        spaces[6][7].putPiece("white_knight");
        spaces[7][7].putPiece("white_rook");
        for (int i = 0; i < 8; i++) {
            spaces[i][6].putPiece("white_pawn");
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

    private Space toMove = null;

    private void handleOnClick() {
        for (int i = 0; i < spaces.length; i++) {
            for (int j = 0; j < spaces[i].length; j++) {
                Space s = spaces[i][j];

                s.getHBox().setOnMousePressed(e -> {
                    if(pressed){
                        toMove.move(s.getX(), s.getY());
                        toMove = null;
                        pressed = false;
                    }
                    else{
                        if (s.isTaken()) {
                            pressed = true;
                            toMove = s;
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
