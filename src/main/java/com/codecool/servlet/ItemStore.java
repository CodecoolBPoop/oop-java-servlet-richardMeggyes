package com.codecool.servlet;

import java.util.ArrayList;
import java.util.List;

public class ItemStore {
    private static ArrayList<Item> items = new ArrayList<Item>();

    public int getItemsNumber(){
        return items.size();
    }

    public ArrayList<String> getItemDetailsById(int id){
        ArrayList<String> itemDetails = new ArrayList<String>();

        Item item = items.get(id);

        itemDetails.add(String.valueOf(item.id));
        itemDetails.add(item.name);
        itemDetails.add(String.valueOf(item.price));

        return itemDetails;
    }

    public void addItemToStore(int id, String name, int price){

        Item item = new Item();

        item.id = id;
        item.name = name;
        item.price = price;

        items.add(item);
    }

    public void removeItemFromStore(Item item){
        items.remove(item);
    }

}
