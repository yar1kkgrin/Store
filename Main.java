import java.util.Scanner;

import static java.lang.System.in;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        Store store = new Store();
        while (true) {
            System.out.println("Select command (add, update, delete, show, search, price range, history, exit)");
            String command = scanner.nextLine();
            switch (command) {
                case "add" -> {
                    System.out.println("Enter product name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter product category (ELECTRONICS, FOOD, CHEMICALS, HOUSEHOLD, GOODS):");
                    Category category = Category.valueOf(scanner.nextLine().toUpperCase());
                    System.out.println("Enter product price:");
                    double price;
                    try {
                        price = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid price format. Please enter a valid number.");
                        continue;
                    }
                    System.out.println("Enter product quantity:");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    Product product = new Product(name, category, price, quantity);
                    store.addProduct(product);
                }
                case "update" -> {
                    System.out.println("Enter product name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter product quantity:");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    store.updateQuantity(name, quantity);
                }
                case "delete" -> {
                    System.out.println("Enter product name:");
                    String name = scanner.nextLine();
                    store.removeProduct(name);
                }
                case "show" -> {
                    System.out.println("Name or category:");
                    String choose = scanner.nextLine();
                    store.showProducts(choose);
                }
                case "search" -> {
                    System.out.println("Enter product category (ELECTRONICS, FOOD, CHEMICALS, HOUSEHOLD, GOODS):");
                    Category category = Category.valueOf(scanner.nextLine().toUpperCase());
                    store.findProductsByCategory(String.valueOf(category));
                }
                case "price range" -> {
                    System.out.println("Enter the minimum and maximum value:");
                    double min = 0;
                    double max = 0;
                    try {
                        min = Double.parseDouble(scanner.nextLine());
                        max = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid price range format. Please enter valid numbers.");
                        continue;
                    }
                    store.findProductsByPriceRange(min, max);
                }
                case "history" -> store.showHistory();
                case "exit" -> {
                    System.out.println("Program is ended");
                    return;
                }
                default -> System.out.println("Unknown command! Try again =)");
            }
        }
    }
}
