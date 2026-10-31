/**
 * PROJECT NAME: URBAN HATCH FARMS ONLINE STORE
 * PROJECT DESCRIPTION: This is an online store for Urban Hatch Farms, where customers can browse and purchase fresh produce and other farm products. The store offers a user-friendly interface, secure payment options, and efficient delivery services.
 * DEVELOPER: MANWEDI CLAUDE
 */

package app;

import java.util.Scanner;
import domain.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" WELCOME TO URBAN HATCH FARMS ONLINE STORE");
        System.out.println("What is your Name?");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "! Welcome to our store.");
        System.out.println("We only have this left in store: ");

        ChickenBatch batch1 = new ChickenBatch("BATCH001", 50, 10.0, 2.5);
        System.out.println(batch1);

        scanner.close();
    }
}