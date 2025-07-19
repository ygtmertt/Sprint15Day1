package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {

  // Public static ArrayList to store grocery items
  public static List<String> groceryList = new ArrayList<>();

  // Method to start the grocery application console interface
  public void startGrocery() {
    Scanner sc = new Scanner(System.in);
    int selection;

    // Loop until the user decides to exit
    do {
      System.out.println("\nHoşgeldiniz!\n" +
          "Ürün eklemek için 1'e basınız.\n" +
          "Ürün çıkarmak için 2'ye basınız.\n" +
          "Programı sonlandırmak için 0'a basınız."
      );
      System.out.print("Seçiminiz: ");

      // Validate integer input
      while (!sc.hasNextInt()) {
        System.out.println("Geçersiz giriş! Lütfen 0, 1 veya 2 giriniz.");
        System.out.print("Seçiminiz: ");
        sc.next(); // Consume the invalid input
      }
      selection = sc.nextInt();
      sc.nextLine(); // Consume the leftover newline character after reading the integer

      switch (selection) {
        case 0:
          System.out.println("Program sonlandırıldı. Güle güle! 👋");
          break;
        case 1:
          System.out.println("Eklemek istediğiniz eleman(ları) giriniz (virgülle ayırarak):");
          String addInput = sc.nextLine();
          addItems(addInput);
          break;
        case 2:
          System.out.println("Çıkarmak istediğiniz eleman(ları) giriniz (virgülle ayırarak):");
          String removeInput = sc.nextLine();
          removeItems(removeInput);
          break;
        default:
          System.out.println("Geçerli bir seçim yapınız (0, 1 veya 2).");
          break;
      }
      printSorted(); // Print the sorted list after each operation
    } while (selection != 0);

    sc.close(); // Close the scanner when the program ends
  }

  // --- Static Helper Methods ---

  /**
   * Adds one or more items to the grocery list.
   * Items are separated by commas.
   * @param input A string containing one or more items, potentially comma-separated.
   */
  public static void addItems(String input) {
    if (input == null || input.trim().isEmpty()) {
      System.out.println("Eklenecek bir ürün girmediniz.");
      return;
    }
    String[] items = input.split(",");
    boolean itemsAdded = false;
    for (String item : items) {
      String trimmedItem = item.trim();
      if (!trimmedItem.isEmpty() && !checkItemIsInList(trimmedItem)) {
        groceryList.add(trimmedItem);
        System.out.println("'" + trimmedItem + "' listeye eklendi.");
        itemsAdded = true;
      } else if (!trimmedItem.isEmpty()) {
        System.out.println("'" + trimmedItem + "' zaten listede mevcut.️");
      }
    }
    if (itemsAdded) {
      Collections.sort(groceryList); // Sort the list after adding items
    }
  }

  /**
   * Removes one or more items from the grocery list.
   * Items are separated by commas.
   * @param input A string containing one or more items, potentially comma-separated.
   */
  public static void removeItems(String input) {
    if (input == null || input.trim().isEmpty()) {
      System.out.println("Çıkarılacak bir ürün girmediniz.");
      return;
    }
    String[] items = input.split(",");
    boolean itemsRemoved = false;
    for (String item : items) {
      String trimmedItem = item.trim();
      if (checkItemIsInList(trimmedItem)) {
        groceryList.remove(trimmedItem);
        System.out.println("'" + trimmedItem + "' listeden çıkarıldı.");
        itemsRemoved = true;
      } else if (!trimmedItem.isEmpty()) {
        System.out.println("'" + trimmedItem + "' listede bulunamadı.");
      }
    }
    if (itemsRemoved) {
      Collections.sort(groceryList); // Sort the list after removing items
    }
  }

  /**
   * Checks if a given product is already in the grocery list.
   * @param product The product name to check.
   * @return true if the product is in the list, false otherwise.
   */
  public static boolean checkItemIsInList(String product) {
    return groceryList.contains(product);
  }

  /**
   * Prints all items in the grocery list in sorted order.
   */
  public static void printSorted() {
    // Ensure the list is sorted before printing
    Collections.sort(groceryList);

    System.out.println("\n--- Mevcut Pazar Arabası Listesi ---");
    if (groceryList.isEmpty()) {
      System.out.println("Liste boş. Hadi biraz ürün ekleyelim! 🛒");
    } else {
      for (int i = 0; i < groceryList.size(); i++) {
        System.out.println((i + 1) + ". " + groceryList.get(i));
      }
    }
    System.out.println("-------------------------------------\n");
  }
}