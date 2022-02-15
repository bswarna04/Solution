package com.example;

import java.util.HashMap;

public class AppSystem extends TheSystem {
    HashMap<String, Item> itemHashMap= getItemCollection();
    AppSystem() {
    }

    @Override
    public void display() {
        System.out.println("AppSystem Inventory:");
        //System.out.println("----------------------------------------------------------------------------");
        System.out.printf("%-20s %-20s %-10s %-10s%n","Name", "Description", "Price", "Available Quantity");
        //System.out.println("----------------------------------------------------------------------------");
        //HashMap <String, Item> itemHashMap= getItemCollection();
        for (Item i : itemHashMap.values()) {
            System.out.printf("%-20s %-20s %-10.2f %-10d%n",i.getItemName(),i.getItemDesc(),i.getItemPrice(),i.getAvailableQuantity());
        }
        //System.out.println("----------------------------------------------------------------------------");
    }



    @Override      // this overwrites the parents class add method
    public Boolean add(Item item) {
        if(item==null){
            return false;
        }else if(itemHashMap.containsKey(item.getItemName()) ){
            System.out.println(item.getItemName() +"is already in collection" );
            return false;
        }else {
            itemHashMap.put(item.getItemName(), item);
            return true;
        }
    }

    public Item reduceAvailableQuantity(String item_name) {

         if(itemHashMap.containsKey(item_name)){

             Item reducedQtyItem = itemHashMap.get(item_name);
             if(reducedQtyItem.getAvailableQuantity() == 1){
                 reducedQtyItem.setAvailableQuantity(0);
                 itemHashMap.remove(item_name);
                 return reducedQtyItem;
             }
             int newAvailQuantity;
             newAvailQuantity = reducedQtyItem.getAvailableQuantity() - 1;
             reducedQtyItem.setAvailableQuantity(newAvailQuantity);
             itemHashMap.replace(item_name,reducedQtyItem);
             return reducedQtyItem;
            }else
                return null;
    }
}
