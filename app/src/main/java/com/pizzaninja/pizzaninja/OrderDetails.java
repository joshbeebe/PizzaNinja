package com.pizzaninja.pizzaninja;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by josh on 11/18/16.
 */

public class OrderDetails {
    private static OrderDetails od = null;
    private int numItems = 0;

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
        public int itemNum;
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
        i.itemNum = numItems;
        numItems++;
        OrderList.add(i);
        totalPrice += i.price;
    }

    public void removeItem(int iNum) {
        for (int i = 0; i < OrderList.size(); i++) {
            if (OrderList.get(i).itemNum == iNum) {
                OrderList.remove(i);
            }
        }
    }

}
