import java.util.*;

import static java.lang.System.in;

public class Store {
    List<Product> products = new ArrayList<>();
    List<String> history = new ArrayList<>();

    public void addProduct(Product product) {
        for (Product i : products) {
            if (i.getName().equals(product.getName())) {
                System.out.println("This product already exists");
                return;
            }
        }
        products.add(product);
        history.add("Added product: " + product.getName());
    }


    public void removeProduct(String productName) {
        productName = productName.trim().toLowerCase();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().trim().toLowerCase().equals(productName)) {
                iterator.remove();
                history.add("Removed product: " + productName);
                System.out.println("Product removed successfully");
                return;
            }
        }
        System.out.println("This product does not exist");
    }


    public void updateQuantity(String productName, int newQuantity) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                int oldQuantity = product.getQuantity();
                product.setQuantity(newQuantity);

                System.out.println("Updated quantity for " + productName + ": " + oldQuantity + " -> " + newQuantity);
                history.add("Updated quantity for " + productName + ": " + oldQuantity + " -> " + newQuantity);
                return;
            }
        }
        System.out.println("Product not found: " + productName);
    }

    public void showProducts(String sortBy) {
        switch (sortBy.toLowerCase()) {
            case "name" -> {
                products.sort(Comparator.comparing(Product::getName));
                System.out.println("Products sorted by name: " + products);
            }
            case "category" -> {
                products.sort(Comparator.comparing(Product::getCategory));
                System.out.println("Products sorted by category: " + products);
            }
            default -> System.out.println("Invalid sorting option. Use 'name' or 'category'.");
        }
    }

    public void findProductsByCategory(String category) {
        String lowerCategory = category.toLowerCase();
        List<Product> foundProducts = new ArrayList<>();

        for (Product product : products) {
            if (product.getCategory().name().toLowerCase().equals(lowerCategory)) {
                foundProducts.add(product);
            }
        }

        if (foundProducts.isEmpty()) {
            System.out.println("There are no products with this category: " + category);
        } else {
            System.out.println("Products in category '" + category + "':");
            for (Product product : foundProducts) {
                System.out.println("- " + product.getName() + " ($" + product.getPrice() + ")");
            }
        }
    }

    public void findProductsByPriceRange(double minPrice, double maxPrice) {
        List<Product> foundProducts = new ArrayList<>();

        for (Product product : products) {
            if (minPrice < product.getPrice() && product.getPrice() < maxPrice) {
                foundProducts.add(product);
            }
        }

        if (foundProducts.isEmpty()) {
            System.out.println("No products found in the price range $" + minPrice + " - $" + maxPrice);
        } else {
            System.out.println("Products in the price range $" + minPrice + " - $" + maxPrice + ":");
            for (Product product : foundProducts) {
                System.out.println("- " + product.getName() + " ($" + product.getPrice() + ")");
            }
        }
    }


    public void showHistory() {
        if (!history.isEmpty()) {
            for (String hist : history) {
                System.out.println(hist);
            }
        } else {
            System.out.println("History is empty");
        }
    }
}
