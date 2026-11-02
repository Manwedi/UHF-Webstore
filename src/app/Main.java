/**
 * PROJECT NAME: URBAN HATCH FARMS ONLINE STORE
 * PROJECT DESCRIPTION: This is an online store for Urban Hatch Farms, where customers can browse and purchase fresh produce and other farm products. The store offers a user-friendly interface, secure payment options, and efficient delivery services.
 * DEVELOPER: MANWEDI CLAUDE
 */

package app;

import java.util.Scanner;
import domain.*;
import repository.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FarmRepository farmData = new FarmRepository();

        System.out.println(" WELCOME TO URBAN HATCH FARMS ONLINE STORE");
        System.out.println("What is your Name?");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "! Welcome to our store.");
        System.out.println("We only have this left in store: ");

        ChickenBatch batch1 = farmData.getBatchById("Batch-001");
        System.out.println(batch1);

        System.out.println(name + " this is your order");
        Order order1 = new Order(farmData.generateOrderId(), name, batch1.getID(), 5, batch1.getPrice() * 5);
        System.out.println(order1);

        scanner.close();
    }
}