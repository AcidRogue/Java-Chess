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
        new Piece("black_rook", 0, 0);
        new Piece("black_knight", 1, 0);
        new Piece("black_bishop", 2, 0);
        new Piece("black_queen", 3, 0);
        new Piece("black_king", 4, 0);
        new Piece("black_bishop", 5, 0);
        new Piece("black_knight", 6, 0);
        new Piece("black_rook", 7, 0);

        new Piece("black_pawn", 0, 1);
        new Piece("black_pawn", 1, 1);
        new Piece("black_pawn", 2, 1);
        new Piece("black_pawn", 3, 1);
        new Piece("black_pawn", 4, 1);
        new Piece("black_pawn", 5, 1);
        new Piece("black_pawn", 6, 1);
        new Piece("black_pawn", 7, 1);

        new Piece("white_rook", 0, 7);
        new Piece("white_knight", 1, 7);
        new Piece("white_bishop", 2, 7);
        new Piece("white_queen", 3, 7);
        new Piece("white_king", 4, 7);
        new Piece("white_bishop", 5, 7);
        new Piece("white_knight", 6, 7);
        new Piece("white_rook", 7, 7);
        new Piece("white_pawn", 0, 6);
        new Piece("white_pawn", 1, 6);
        new Piece("white_pawn", 2, 6);
        new Piece("white_pawn", 3, 6);
        new Piece("white_pawn", 4, 6);
        new Piece("white_pawn", 5, 6);
        new Piece("white_pawn", 6, 6);
        new Piece("white_pawn", 7, 6);
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

                spaces[i][j] = new Space(i, j);
                if (counter % 2 == 0) {
                    spaces[i][j].setStyle(true);
                } else {
                    spaces[i][j].setStyle(false);
                }



                gridPane.add(spaces[i][j].getHBox(), i, j);

                counter++;
            }
        }

        gridPane.setGridLinesVisible(true);

        return gridPane;
    }

    private void handleOnClick(){
        for (int i = 0; i < spaces.length; i++) {
            for (int j = 0; j < spaces[i].length; j++) {
                boolean taken = spaces[i][j].getTaken();
                spaces[i][j].getHBox().setOnMouseClicked(e -> {
                    if(taken){
                        System.out.println("aaaa");
                    }
                });
            }
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
