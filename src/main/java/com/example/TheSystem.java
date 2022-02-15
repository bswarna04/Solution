package com.example;

import java.io.*;
import java.util.*;
import java.lang.*;

public abstract class TheSystem {

    private HashMap<String, Item> itemCollection = new HashMap<String, Item>();

    TheSystem() {
        itemCollection = new HashMap<>();
        if(getClass().getSimpleName().equals("AppSystem")){
        try {
            String location = "resources\\sample.txt";
            File file = new File(location);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] itemInfo=line.split("\\s ");
                String itemName = itemInfo[0];
                String itemDesc = itemInfo[1];
                Double itemPrice = Double.parseDouble(itemInfo[2]);
                Integer availQuantity = Integer.parseInt(itemInfo[3]);

                Item item = new Item(itemName,itemDesc,itemPrice,availQuantity);
                itemCollection.put(itemInfo[0],item);
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
             }

        }
    }

    public HashMap<String, Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(HashMap<String, Item> itemCollection) {
        this.itemCollection = itemCollection;
    }

    
    public Boolean checkAvailability(Item item) {
        if (item != null) {
            if (item.getQuantity() >= item.getAvailableQuantity()) {
                System.out.println("System is unable to add " + item.getItemName() + " to the cart. System only has " + item.getAvailableQuantity() + " " + item.getItemName() + "s.");
                return false;
            } else
                return true;
        } else {
            System.out.println("Invalid or Unavailable Item, Please Try Again");
            return false;
        }
    }
    
    public Boolean add(Item item) {
        if (item == null){
            return false;
        }else if(itemCollection.containsKey(item.getItemName())){
            System.out.println("I am here3");
            int newQuantity;
            newQuantity=item.getQuantity()+1;
            item.setQuantity(newQuantity);
            System.out.println("new quantity is:" +newQuantity);
            return true;

        }else if(!itemCollection.containsKey(item.getItemName())){
            itemCollection.put(item.getItemName(),item);
            return true;
        }else return false;

    }

    public Item remove(String itemName) {
      if(itemCollection.containsKey(itemName)){
          Item removeditem= itemCollection.get(itemName);
          itemCollection.remove(itemName);
          return removeditem;
      }else return null;

    }

    public abstract void display();

}
