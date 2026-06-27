package Module_2_Data_Structures_and_Algorithms.Exercise_1.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class InventoryManagementSystem {

    static HashMap<Integer, Product> products = new HashMap<>();

    public static void addProduct(Product p1){
        if (products.containsKey(p1.productId)){
            System.out.println("\nProduct already exists!");
            return;
        }
        products.put(p1.productId, p1);
        System.out.println("Product added successfully!");
    }

    public static void deleteProduct(int pId){
        if (products.remove(pId) != null){
            System.out.println("Product Deleted Successfully!");
        } else {
            System.out.println("Product Not Found!");
        }
    }

    public static void updateProduct(int pId, Scanner sc){
        Product p = products.get(pId);

        if (p == null){
            System.out.println("Product Not Found!");
            return;
        }

        System.out.print("Do you want to Update the Product Name (Y/N): ");
        String response = sc.next();

        if (response.equalsIgnoreCase("Y")){
            System.out.print("\nEnter the Updated Product Name: ");
            String name = sc.next();
            p.productName = name;
            System.out.println("Product Name Updated Successfully!");
        }

        System.out.print("\nDo you want to Update the Product Quantity (Y/N): ");
        response = sc.next();

        if (response.equalsIgnoreCase("Y")){
            System.out.print("\nEnter the Updated Quantity: ");
            int qty = sc.nextInt();
            p.quantity = qty;
            System.out.println("Product Quantity Updated Successfully!");
        }

        System.out.print("\nDo you want to Update the Price (Y/N): ");
        response = sc.next();

        if (response.equalsIgnoreCase("Y")){
            System.out.print("\nEnter the Updated Price: ");
            float price = sc.nextFloat();
            p.price = price;
            System.out.println("Product Quantity Updated Successfully!");
        }
    }

    public static void searchProduct(int pId){
        Product p = products.get(pId);

        if (p == null){
            System.out.println("Product Not Found!");
        }

        System.out.println("\nDetails of the Product are as follows:");
        System.out.println("Product Id: "+p.productId);
        System.out.println("Product Name: "+p.productName);
        System.out.println("Quantity: "+p.quantity);
        System.out.println("Price: "+p.price);
    }

    public static void viewProducts(){
        if (products.isEmpty()){
            System.out.println("No Products Found!");
            return;
        }

        System.out.printf("%-10s %-10s %-10s %-10s\n", "PId", "PName", "Quantity", "Price");
        
        for (Product p : products.values()){
            System.out.printf("%-10d %-10s %-10d %-10.2f\n", p.productId, p.productName, p.quantity, p.price);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\nSelect one of the option from below:");
            System.out.println("1. Add a Product");
            System.out.println("2. Delete a Product");
            System.out.println("3. Update a Product");
            System.out.println("4. Search a Product");
            System.out.println("5. View the Product List");
            System.out.println("0. Exit");

            System.out.print("Enter your Choice: ");
            int choice = sc.nextInt();
            int pId;

            switch(choice){
                case 1:
                    System.out.print("\nEnter the Product ID: ");
                    pId = sc.nextInt();

                    System.out.print("Enter the Product Name: ");
                    String pName = sc.next();
                    
                    System.out.print("Enter the Quantity: ");
                    int qty = sc.nextInt();

                    System.out.print("Enter the Price: ");        
                    float price = sc.nextFloat();

                    Product p1 = new Product(pId, pName, qty, price);
                    addProduct(p1);
                    break;
                
                case 2:
                    System.out.print("\nEnter the Product ID to delete: ");
                    pId = sc.nextInt();
                    deleteProduct(pId);
                    break;

                case 3:
                    System.out.print("\nEnter the Product ID to update: ");
                    pId = sc.nextInt();
                    updateProduct(pId, sc);
                    break;

                case 4:
                    System.out.print("\nEnter the Product ID to search: ");
                    pId = sc.nextInt();
                    searchProduct(pId);
                    break;

                case 5:
                    viewProducts();
                    break;

                case 0:
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!!");
                    break;
            }
        }
    }
}
