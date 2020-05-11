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
    selecttable a = new selecttable();
    selecttable b = new selecttable();
    selecttable c = new selecttable();
    selecttable d = new selecttable();
    selecttable e = new selecttable();
    selecttable f = new selecttable();
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
        double a1 = a.selectPay(1);
        if (a1 != 0.0){
            Alert alert = new Alert(Alert.AlertType.WARNING, "Masa dolu!");
            alert.showAndWait();
        }

        else {

            checker[0] = true;
            app.updateAll(1, true, price());

            Node node = FXMLLoader.load(getClass().getResource("show.fxml"));
            tablesAnchor.getChildren().setAll(node);

        }
    }
    @FXML
    void table2Check(ActionEvent actionEvent) throws IOException {
        getArray();
        double a2 = a.selectPay(2);
        if (a2 != 0.0){
            Alert alert = new Alert(Alert.AlertType.WARNING, "Masa dolu!");
            alert.showAndWait();
        }

        else {
            checker[1] = true;
            app.updateAll(2, true, price());
            Node node = FXMLLoader.load(getClass().getResource("show.fxml"));
            tablesAnchor.getChildren().setAll(node);
        }
    }
    @FXML
    void table3Check(ActionEvent actionEvent) throws IOException {
        getArray();
        double a3 = a.selectPay(3);
        if (a3 != 0.0){
            Alert alert = new Alert(Alert.AlertType.WARNING, "Masa dolu!");
            alert.showAndWait();
        }

        else {
            checker[2] = true;
            app.updateAll(3, true, price());
            Node node = FXMLLoader.load(getClass().getResource("show.fxml"));
            tablesAnchor.getChildren().setAll(node);
        }
    }
    @FXML
    void table4Check(ActionEvent actionEvent) throws IOException {
        getArray();
        double a4 = a.selectPay(4);
        if (a4 != 0.0){
            Alert alert = new Alert(Alert.AlertType.WARNING, "Masa dolu!");
            alert.showAndWait();
        }

        else {
            checker[3] = true;
            app.updateAll(4, true, price());
            Node node = FXMLLoader.load(getClass().getResource("show.fxml"));
            tablesAnchor.getChildren().setAll(node);
        }
    }
    @FXML
    void table5Check(ActionEvent actionEvent) throws IOException {
        getArray();
        double a5 = a.selectPay(5);
        if (a5 != 0.0){
            Alert alert = new Alert(Alert.AlertType.WARNING, "Masa dolu!");
            alert.showAndWait();
        }

        else {
            checker[4] = true;
            app.updateAll(5, true, price());

            Node node = FXMLLoader.load(getClass().getResource("show.fxml"));
            tablesAnchor.getChildren().setAll(node);
        }
    }
    @FXML
    void table6Check(ActionEvent actionEvent) throws IOException {
        getArray();
        double a6 = a.selectPay(6);
        if (a6 != 0.0){
            Alert alert = new Alert(Alert.AlertType.WARNING, "Masa dolu!");
            alert.showAndWait();
        }

        else {
            checker[5] = true;
            app.updateAll(6, true, price());
            Node node = FXMLLoader.load(getClass().getResource("show.fxml"));
            tablesAnchor.getChildren().setAll(node);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fonk();
    }

    public void fonk(){
        double a1 = a.selectPay(1);
        if (a1 != 0){
            table1.setStyle("-fx-background-color: red");
            System.out.println(a1);
        }
        double a2 = b.selectPay(2);

        if (a2 != 0){
            table2.setStyle("-fx-background-color: red");
            System.out.println(a2);
        }
        double a3 = c.selectPay(3);

        if (a3 != 0){
            table3.setStyle("-fx-background-color: red");
            System.out.println(a3);
        }
        double a4 = d.selectPay(4);

        if (a4 != 0){
            table4.setStyle("-fx-background-color: red");
            System.out.println(a4);
        }
        double a5 = e.selectPay(5);

        if (a5 != 0){
            table5.setStyle("-fx-background-color: red");
            System.out.println(a5);
        }
        double a6 = f.selectPay(6);

        if (a6 != 0){
            table6.setStyle("-fx-background-color: red");
            System.out.println(a6);
            System.out.println("----------------------");
        }
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

