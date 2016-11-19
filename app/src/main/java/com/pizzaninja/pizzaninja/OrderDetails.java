package com.pizzaninja.pizzaninja;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by josh on 11/18/16.
 */

public class OrderDetails {
    private static OrderDetails od = null;
    public static OrderDetails getInstance() {
        if (od == null) {
            od = new OrderDetails();
        }
        return od;

    }
    public static class Item {
        String name;
        Double price;
        Double pricePerTopping;
        ArrayList<String> toppings;

        public Item(String name, Double price) {
            this.name = name;
            this.price = price;
            toppings = new ArrayList<>();
        }

        public void addTopping(String t) {
            toppings.add(t);
            price += pricePerTopping;
        }
        public void setPricePerTopping(Double p) { pricePerTopping = p; }

    }

//    public class Pizza extends Item {
//        Integer numToppings;
//    }


    public ArrayList<Item> OrderList = new ArrayList<Item>();
    Double totalPrice = 0.0;

    public void addItem(Item i) {
        OrderList.add(i);
        totalPrice += i.price;
    }


}
