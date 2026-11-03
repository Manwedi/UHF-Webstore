/**
 * PROJECT NAME: URBAN HATCH FARMS ONLINE STORE
 * PROJECT DESCRIPTION: This is an online store for Urban Hatch Farms, where customers can browse and purchase fresh produce and other farm products. The store offers a user-friendly interface, secure payment options, and efficient delivery services.
 * DEVELOPER: MANWEDI CLAUDE
 */

package app;

import java.util.List;
import java.util.Scanner;
import domain.*;
import repository.*;
import service.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FarmRepository farmData = new FarmRepository();

        boolean running = true;

        while (running) {

            System.out.println(" ********   WELCOME TO URBAN HATCH FARMS ONLINE STORE    ********");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Please browse our products and place your order.");
            System.out.println("What is your Name?");
            String name = scanner.nextLine();
            System.out.println("Hello, " + name + "! Welcome to our store.");
            System.out.println("********    MENU    ********");
            System.out.println("1. Browse Products");
            System.out.println("2. Place Order");
            System.out.println("3. Exit");
            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumes the newline character

            FarmService farmService = new FarmService(farmData);


            switch (choice) {
                case 1:
                    System.out.println("\n--- AVAILABLE BATCHES ---");
                        List<ChickenBatch> batches = farmService.getAllBatches();
                        if (batches.isEmpty()) {
                            System.out.println("No batches are currently available for purchase.");
                        } else {
                            for (ChickenBatch b : batches) {
                                System.out.println(b);
                            }
                        }
                        break;
                case 2:
                    System.out.println("\n--- PLACE AN ORDER ---");
                        System.out.print("Enter Customer Name: ");
                        String customerName = scanner.nextLine();
                        
                        System.out.print("Enter Batch ID (e.g., Batch-001): ");
                        String batchId = scanner.nextLine();
                        
                        System.out.print("Enter Quantity to Buy: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        try {
                            // Processes the transaction through your service layer business logic
                            Order order = farmService.placeOrder(customerName, batchId, quantity);
                            System.out.println("\n[SUCCESS] Order placed successfully!");
                            System.out.println(order);
                        } catch (Exception e) {
                            System.out.println("\n[ERROR] Could not place order: " + e.getMessage());
                        }
                        break;
                case 3:
                    System.out.println("Thank you for visiting Urban Hatch Farms Online Store. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        }
        
        scanner.close();
    }
}