package com.example;

import java.util.HashMap;

public class CartSystem extends TheSystem {
    CartSystem() {
    }

      @Override
    public void display() {
          HashMap<String, Item> itemHashMap= getItemCollection();
          float pre_tax_Total=0;
          System.out.println("Cart:");
          //System.out.println("---------------------------------------------------------------------------------");
          System.out.printf("%-20s %-20s %-10s %-10s %-10s","Name", "Description", "Price", "Quantity", "Sub Total");
          System.out.print("\n");
          //System.out.println("---------------------------------------------------------------------------------");
          for (Item i : itemHashMap.values()) {
              System.out.printf("%-20s %-20s %-10.2f %-10d %-10.2f",i.getItemName(),i.getItemDesc(),i.getItemPrice(),i.getQuantity(),i.getItemPrice()*i.getQuantity());
              System.out.print("\n");
              pre_tax_Total=pre_tax_Total+(float)(i.getItemPrice()*i.getQuantity());
          }

          //System.out.println("----------------------------------");
          System.out.printf("%-20s %-20.2f","Pre-tax Total" ,pre_tax_Total);
          System.out.print("\n");
          float tax= (float) (pre_tax_Total * 0.05);
          System.out.printf("%-20s %-20.2f" , "Tax" , tax);
          System.out.print("\n");
          float total=pre_tax_Total+tax;
          System.out.printf("%-20s %-20.2f" ,"Total" , total);
          System.out.print("\n");
         /* System.out.print("Cart:\n" +
                  "Name                 Description          Price      Quantity   Sub Total \n" +
                  "Pre-tax Total        0.00                \n" +
                  "Tax                  0.00                \n" +
                  "Total                0.00                \n"); */


    }
}
