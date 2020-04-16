package sample;

import com.sun.org.apache.xml.internal.security.Init;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class paymentController implements Initializable {

    @FXML public TextField tableNumbertf;
    @FXML private TextField cardNametf;
    @FXML private TextField cardDatetf;
    @FXML private TextField cardCodetf;
    @FXML private TextField cardNumbertf;
    @FXML private Button cardInfoSubmitBtn;
    @FXML private Button backBtn;
    @FXML private Button tablenumberbutton;
    @FXML private Label paymentLabel;


    @FXML private AnchorPane paymentAnchor = new AnchorPane();

    @FXML
    void cardInfoSubmit(ActionEvent event) throws SQLException, IOException {
        if(cardNametf == null || cardCodetf == null || cardDatetf == null ||
                cardNumbertf == null){
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter a valid card information!");
            alert.showAndWait();
            Node node = FXMLLoader.load(getClass().getResource("payment.fxml"));
            paymentAnchor.getChildren().setAll(node);
        }

        String name = cardNametf.getText();
        String date = cardDatetf.getText();
        String code = cardCodetf.getText();
        String number = cardNumbertf.getText();

        if(number.length() != 1 || name == null || code.length() != 1 || date.length() != 1){
            //error
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter a valid card information!");
            alert.showAndWait();
            Node node = FXMLLoader.load(getClass().getResource("payment.fxml"));
            paymentAnchor.getChildren().setAll(node);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Your order has been received. Thank You!");
            alert.showAndWait();
        }
        int gettable = Integer.parseInt(tableNumbertf.getText());
        UpdateApp app = new UpdateApp();
        app.updateAll(gettable,false,0.0);
    }

    @FXML
    void back() throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("initial.fxml"));
        paymentAnchor.getChildren().setAll(node);
    }

    @FXML
    void hesapbul(){
        int gettable = Integer.parseInt(tableNumbertf.getText());
        selecttable select = new selecttable();
        double a = select.selectPay(gettable);
        // update the warehouse with id 3
        paymentLabel.setText(String.valueOf(a));

    }

    @FXML
    void creditExit(ActionEvent event) {
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }
}