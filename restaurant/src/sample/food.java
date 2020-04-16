/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import javafx.beans.property.SimpleStringProperty;


public class food {


    private final SimpleStringProperty name;
    private final SimpleStringProperty price;

    public food(String name, String price) {
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleStringProperty(price);
    }

    public String getName() {
        return name.get();
    }
    public void setName(String fName) {
        name.set(fName);
    }

    public String getPrice() {
        return price.get();
    }
    public void setPrice(String fName) {
        price.set(fName);
    }
}