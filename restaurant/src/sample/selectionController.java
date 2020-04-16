//package sample;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.control.Button;
//import javafx.scene.control.CheckBox;
//import javafx.scene.layout.AnchorPane;
//
//
//public class selectionController {
//    @FXML
//    private AnchorPane foodAnchor = new AnchorPane();
//    @FXML
//    private CheckBox hamburger;
//    @FXML
//    private CheckBox pizza;
//    @FXML
//    private CheckBox salad;
//    @FXML
//    private CheckBox iskender;
//    @FXML
//    private CheckBox kola;
//    @FXML
//    private CheckBox coffee;
//    @FXML
//    private CheckBox soup;
//    @FXML
//    private CheckBox cheeseburger;
//    @FXML
//    private Button nextbutton;
//    @FXML
//    private Button exitBtn;
//    @FXML
//    private Button backbuttonselection;
//
//    public static ArrayList<String> finalList;
//    static ArrayList<String> list;
//    static boolean [] array;
//    static ArrayList<String> priceList;
//    tablesController t = new tablesController();
//
//
//    @FXML
//    void nextEvent(ActionEvent actionEvent) throws IOException {
//        getArray();
//        Node node = FXMLLoader.load(getClass().getResource("show.fxml"));
//        foodAnchor.getChildren().setAll(node);
//    }
//
//    @FXML
//    void backselection() throws IOException {
//        Node node = FXMLLoader.load(getClass().getResource("tables.fxml"));
//        foodAnchor.getChildren().setAll(node);
//    }
//
//    @FXML
//    void exit(){
//        System.exit(3);
//    }
//
//    void getArray(){
//        list = new ArrayList<>();
//        array = new boolean[8];
//        priceList = new ArrayList<>();
//
//        array[0] = hamburger.isSelected();
//        array[1] = pizza.isSelected();
//        array[2] = salad.isSelected();
//        array[3] = iskender.isSelected();
//        array[4] = kola.isSelected();
//        array[5] = coffee.isSelected();
//        array[6] = soup.isSelected();
//        array[7] = cheeseburger.isSelected();
//
//        list.add("Hamburger");
//        list.add("Pizza");
//        list.add("Salad");
//        list.add("İskender");
//        list.add("Kola");
//        list.add("Coffee");
//        list.add("Soup");
//        list.add("Cheeseburger");
//
//
//        priceList.add("20.0");
//        priceList.add("19.90");
//        priceList.add("10.0");
//        priceList.add("25.90");
//        priceList.add("4.90");
//        priceList.add("7.90");
//        priceList.add("5.90");
//        priceList.add("18.90");
//
//    }
//
//    ArrayList <food> setArray(){
//        ArrayList<food>copiedList;
//        copiedList = new ArrayList<>();
//        for(int i = 0; i<list.size(); i++){
//            if(array[i]){
//                food selectedFood = new food(list.get(i),priceList.get(i));
//                copiedList.add(selectedFood);
//            }
//        }
//        return copiedList;
//    }
//
//    public double sum(){
//        double summation = 0.0;
//        ArrayList<food> getPrices = setArray();
//        for(int i =0; i<getPrices.size(); i++){
//            double price = Double.parseDouble(getPrices.get(i).getPrice());
//            summation+=price;
//        }
//        return summation;
//    }
//}