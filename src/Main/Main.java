package Main;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    private double canvasWidth = 600;
    private double canvasHeight = 600;

    public static GridPane gridPane;

    @Override
    public void start(Stage primaryStage) throws Exception{


        Parent root = createGridPane();
        primaryStage.setTitle("Chess");
        primaryStage.setScene(new Scene(root, canvasWidth, canvasHeight));
        primaryStage.show();



        placePieces();
    }


    void placePieces() {
        new Piece("black_rook", 0);
        new Piece("black_knight", 8);
        new Piece("black_bishop", 16);
        new Piece("black_queen", 24);
        new Piece("black_king",32 );
        new Piece("black_bishop", 40);
        new Piece("black_knight", 48);
        new Piece("black_rook", 56);
        new Piece("black_pawn", 1);
        new Piece("black_pawn", 9);
        new Piece("black_pawn", 17);
        new Piece("black_pawn", 25);
        new Piece("black_pawn", 33);
        new Piece("black_pawn", 41);
        new Piece("black_pawn", 49);
        new Piece("black_pawn", 57);

        new Piece("white_rook", 7);
        new Piece("white_knight", 15);
        new Piece("white_bishop", 23);
        new Piece("white_queen", 31);
        new Piece("white_king", 39);
        new Piece("white_bishop", 47);
        new Piece("white_knight", 55);
        new Piece("white_rook", 63);
        new Piece("white_pawn", 6);
        new Piece("white_pawn", 14);
        new Piece("white_pawn", 22);
        new Piece("white_pawn", 30);
        new Piece("white_pawn", 38);
        new Piece("white_pawn", 46);
        new Piece("white_pawn", 54);
        new Piece("white_pawn", 62);
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
                if (counter % 2 == 0) {
                    HBox hBox = new HBox();
                    hBox.setStyle("-fx-background-color: #444444");
                    hBox.setAlignment(Pos.CENTER);
                    gridPane.add(hBox, i, j);
                } else {
                    HBox hBox = new HBox();
                    hBox.setAlignment(Pos.CENTER);
                    gridPane.add(hBox, i, j);
                }
                counter++;
            }
        }

        gridPane.setGridLinesVisible(true);

        return gridPane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
