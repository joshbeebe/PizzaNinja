package com.pizzaninja.pizzaninja;
import java.util.List;


public class StoreInfo extends ContactInfo{
    public List<MenuItem> MenuItems;
    public List<ContactInfo> Managers;
    public String Hours;
    public Boolean hasDelivery = false;
}
