package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class initialController {
    @FXML
    private Button pay;
    @FXML
    private Button order;
    @FXML
    private Button exitBtn;

    @FXML
    void exit(){
        System.exit(3);
    }

    @FXML
    void orderwithmenu(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("tables.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("Surmeli Restaurant");
        primaryStage.setScene(new Scene(root, 950, 900));
        primaryStage.show();
    }

    @FXML
    void payWithCard(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("payment.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("Surmeli Restaurant");
        primaryStage.setScene(new Scene(root, 950, 600));
        primaryStage.show();
    }
}
