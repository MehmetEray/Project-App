package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class tablesController implements Initializable {
    @FXML
    private Button table1;
    @FXML
    private Button table2;
    @FXML
    private Button table3;
    @FXML
    private Button table4;
    @FXML
    private Button table5;
    @FXML
    private Button table6;
    @FXML
    private Button backbtn;
    @FXML
    private Button nextTablesbutton;
    @FXML
    private AnchorPane tablesAnchor;
    @FXML
    private AnchorPane foodAnchor = new AnchorPane();
    @FXML
    private CheckBox hamburger;
    @FXML
    private CheckBox pizza;
    @FXML
    private CheckBox salad;
    @FXML
    private CheckBox iskender;
    @FXML
    private CheckBox kola;
    @FXML
    private CheckBox coffee;
    @FXML
    private CheckBox soup;
    @FXML
    private CheckBox cheeseburger;
    @FXML
    private Button exitBtn;
    @FXML
    private Button backbuttonselection;
    public double table1Pay = 0;
    public double table2Pay = 0;
    public double table3Pay = 0;
    public double table4Pay = 0;
    public double table5Pay = 0;
    public double table6Pay = 0;


    static ArrayList<String> list;
    static boolean [] array;
    static ArrayList<String> priceList;

    public boolean[] checker = new boolean[6];
    UpdateApp app = new UpdateApp();
    selecttable select = new selecttable();

    @FXML
    void exit(){
        System.exit(3);
    }

    @FXML
    void nextStep(ActionEvent actionEvent) throws IOException {
        TableCheck();
        Parent root = FXMLLoader.load(getClass().getResource("selection.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("Surmeli Restaurant");
        primaryStage.setScene(new Scene(root, 950, 600));
        primaryStage.show();
    }

    public void TableCheck() {
        for(int i =0;i<6;i++){
            if (checker[i]){
                System.out.println("Table " + i + " acildi");
            }
        }
    }

    @FXML
    void table1Check(ActionEvent actionEvent) throws IOException {
        getArray();
        boolean a = select.selectDurum(1);
        if (a){
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter a valid card information!");
            alert.showAndWait();
            System.out.println("asdasdasds");
        }
        else {
            checker[0] = true;
            app.updateAll(1, true, price());
            table1.setStyle("-fx-background-color: red");

            Node node = FXMLLoader.load(getClass().getResource("show.fxml"));
            tablesAnchor.getChildren().setAll(node);
            System.out.println("12342143124");
        }
    }
    @FXML
    void table2Check(ActionEvent actionEvent) throws IOException {
        getArray();
        checker[1] = true;
        app.updateAll(2,true, price());
        table2.setStyle("-fx-background-color: red");
        Node node = FXMLLoader.load(getClass().getResource("show.fxml"));
        tablesAnchor.getChildren().setAll(node);
    }
    @FXML
    void table3Check(ActionEvent actionEvent) throws IOException {
        getArray();
        checker[2] = true;
        app.updateAll(3,true, price());
        table3.setStyle("-fx-background-color: red");
        Node node = FXMLLoader.load(getClass().getResource("show.fxml"));
        tablesAnchor.getChildren().setAll(node);
    }
    @FXML
    void table4Check(ActionEvent actionEvent) throws IOException {
        getArray();
        checker[3] = true;
        app.updateAll(4,true, price());
        table4.setStyle("-fx-background-color: red");
        Node node = FXMLLoader.load(getClass().getResource("show.fxml"));
        tablesAnchor.getChildren().setAll(node);
    }
    @FXML
    void table5Check(ActionEvent actionEvent) throws IOException {
        getArray();
        checker[4] = true;
        app.updateAll(5,true, price());
        table5.setStyle("-fx-background-color: red");
        Node node = FXMLLoader.load(getClass().getResource("show.fxml"));
        tablesAnchor.getChildren().setAll(node);
    }
    @FXML
    void table6Check(ActionEvent actionEvent) throws IOException {
        getArray();
        checker[5] = true;
        app.updateAll(6,true, price());
        table6.setStyle("-fx-background-color: red");
        Node node = FXMLLoader.load(getClass().getResource("show.fxml"));
        tablesAnchor.getChildren().setAll(node);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        table1.setStyle("-fx-background-color: green");
        table2.setStyle("-fx-background-color: green");
        table3.setStyle("-fx-background-color: green");
        table4.setStyle("-fx-background-color: green");
        table5.setStyle("-fx-background-color: green");
        table6.setStyle("-fx-background-color: green");

    }

    @FXML
    void back() throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("initial.fxml"));
        tablesAnchor.getChildren().setAll(node);
    }


    void getArray(){
        list = new ArrayList<>();
        array = new boolean[8];
        priceList = new ArrayList<>();

        array[0] = hamburger.isSelected();
        array[1] = pizza.isSelected();
        array[2] = salad.isSelected();
        array[3] = iskender.isSelected();
        array[4] = kola.isSelected();
        array[5] = coffee.isSelected();
        array[6] = soup.isSelected();
        array[7] = cheeseburger.isSelected();

        list.add("Hamburger");
        list.add("Pizza");
        list.add("Salad");
        list.add("İskender");
        list.add("Kola");
        list.add("Coffee");
        list.add("Soup");
        list.add("Cheeseburger");


        priceList.add("20.0");
        priceList.add("19.90");
        priceList.add("10.0");
        priceList.add("25.90");
        priceList.add("4.90");
        priceList.add("7.90");
        priceList.add("5.90");
        priceList.add("18.90");

    }

    ArrayList <food> setArray(){
        ArrayList<food>copiedList;
        copiedList = new ArrayList<>();
        for(int i = 0; i<list.size(); i++){
            if(array[i]){
                food selectedFood = new food(list.get(i),priceList.get(i));
                copiedList.add(selectedFood);
            }
        }
        return copiedList;
    }

    public double sum(){
        double summation = 0.0;
        ArrayList<food> getPrices = setArray();
        for(int i =0; i<getPrices.size(); i++){
            double price = Double.parseDouble(getPrices.get(i).getPrice());
            summation+=price;
        }
        return summation;
    }

    public double price(){
        double sum = 0.0;
        if (hamburger.isSelected()){
            sum+=20;
        }
        if (pizza.isSelected()){
            sum+=19.90;
        }
        if (salad.isSelected()){
            sum+=10;
        }
        if (iskender.isSelected()){
            sum+=25.90;
        }
        if (kola.isSelected()){
            sum+=4.90;
        }
        if (coffee.isSelected()){
            sum+=7.90;
        }
        if (soup.isSelected()){
            sum+=5.90;
        }
        if (cheeseburger.isSelected()){
            sum+=18.90;
        }
        return sum;
    }
}

