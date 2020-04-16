package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class showController implements Initializable {

    ObservableList<food>list;

    ArrayList<food>foodList;

    @FXML
    private TableView<food> foodTable;


    @FXML
    private Label amount;

    double summation;

    @FXML
    private AnchorPane amountAnchor = new AnchorPane();

    @FXML private Button backBtn;

    public void getTableData() throws IOException{
        foodList = new ArrayList<>();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tables.fxml"));
        Parent root = loader.load();
        tablesController controller = loader.getController();
        foodList = controller.setArray();
        summation = controller.sum();
        amount.setText(String.format("%.2f", summation));
        list = FXCollections.observableArrayList(foodList);

        TableColumn<food, String>col1 = new TableColumn<>("Food Name");
        col1.setMinWidth(475);
        TableColumn<food, String>col2 = new TableColumn<>("Price");
        col2.setMinWidth(475);

        foodTable.getColumns().addAll(Arrays.asList(col1,col2));

        col1.setCellValueFactory(new PropertyValueFactory<>("name"));
        col2.setCellValueFactory(new PropertyValueFactory<>("price"));

        foodTable.setItems(list);

    }

    @FXML
    void back() throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("tables.fxml"));
        amountAnchor.getChildren().setAll(node);
    }
    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            getTableData();
            // TODO
        } catch (IOException ex) {
            Logger.getLogger(showController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}