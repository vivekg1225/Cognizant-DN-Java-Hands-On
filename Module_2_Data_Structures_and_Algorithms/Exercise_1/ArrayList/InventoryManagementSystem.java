// Exercise 1: Inventory Management System Using ArrayList
// You are developing an inventory management system for a warehouse. Efficient data storage and retrieval are crucial.
// o Define a class Product with attributes like productId, productName, quantity, and price.
// o Choose an appropriate data structure to store the products (e.g., ArrayList, HashMap).
// o Implement methods to add, update, and delete products from the inventory.

package Module_2_Data_Structures_and_Algorithms.Exercise_1.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManagementSystem {
    
    public static void addProduct(ArrayList<Product> product, Product p1){
        for (Product p : product){
            if (p.productId == p1.productId){
                System.out.println("Product Id already exists!");
                return;
            }
        }
        product.add(p1);
        System.out.println("\nProduct added Successfully!\n");
    }

    public static void deleteProduct(ArrayList<Product> products, int pId){
        for (int i=0; i<products.size(); i++){
            if (products.get(i).productId == pId){
                products.remove(i);
                System.out.println("Product Deleted Successfully!");
                return;
            }
        }
        System.out.println("Product Not Found!");
    }

    public static void updateProduct(ArrayList<Product> products, int pId, Scanner sc){
        for (Product p : products){
            if (p.productId == pId){
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
                break;
            }
        }
    }

    public static void searchProduct(ArrayList<Product> products, int pId){
        for (Product p : products){
            if (p.productId == pId){
                System.out.println("\nDetails of the Product are as follows:");
                System.out.println("Product Id: "+p.productId);
                System.out.println("Product Name: "+p.productName);
                System.out.println("Quantity: "+p.quantity);
                System.out.println("Price: "+p.price);
                return;
            }
        }
        System.out.println("Product Not Found!!");
    }

    public static void viewProducts(ArrayList<Product> products){
        System.out.printf("%-10s %-10s %-10s %-10s\n","PId","PName","Quantity","Price");
        for (Product p : products){
            System.out.printf("%-10d %-10s %-10d %-10.2f\n", p.productId, p.productName, p.quantity, p.price);
        }
    }
    public static void main(String[] args){
        ArrayList<Product> products = new ArrayList<>();
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
                    addProduct(products, p1);
                    break;
                
                case 2:
                    System.out.print("\nEnter the Product ID to delete: ");
                    pId = sc.nextInt();
                    deleteProduct(products, pId);
                    break;

                case 3:
                    System.out.print("\nEnter the Product ID to update: ");
                    pId = sc.nextInt();
                    updateProduct(products, pId, sc);
                    break;

                case 4:
                    System.out.print("\nEnter the Product ID to search: ");
                    pId = sc.nextInt();
                    searchProduct(products, pId);
                    break;

                case 5:
                    viewProducts(products);
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
