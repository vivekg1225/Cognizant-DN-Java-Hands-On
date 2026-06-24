package Module_2_Data_Structures_and_Algorithms.Exercise_2;

import java.util.Scanner;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category){
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public void display(){
        System.out.println("Product ID: "+ productId);
        System.out.println("Product Name: "+ productName);
        System.out.println("Product Category: "+ category);
    }
}

public class EcommerceSearch{

    public static int steps = 0;

    // Linear Search
    public static Product linearSearch(Product[] products, int id){
        int n = products.length;
        steps = 0;

        for (int i=0; i<n; i++){
            steps++;
            if (products[i].productId == id){
                return products[i];
            }
        }

        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, int id){
        int low = 0;
        int high = products.length - 1;
        steps = 0;

        while (low <= high){
            steps++;
            int mid = (low + high)/2;
            
            if (products[mid].productId == id){
                return products[mid];
            }
            else if (products[mid].productId > id){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return null;
    }

    public static void main(String[] args){
        Product[] products = {
            new Product(101, "Pencil", "Stationary"),
            new Product(102, "Pen", "Stationary"),
            new Product(103, "Laptop", "Electronics"),
            new Product(104, "Mouse", "Electronics"),
            new Product(105, "Mobile", "Electronics"),
            new Product(106, "Tshirt", "Fashion"),
            new Product(107, "Shoes", "Fashion"),
            new Product(108, "Scarf", "Fashion")
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID to search: ");
        int searchId = sc.nextInt();

        System.out.println("\nSelect the type of Searching Algorithm to use: ");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");

        System.out.print("\nEnter your choice: ");
        int choice = sc.nextInt();

        Product result = null;

        switch(choice){
            case 1:
                result = linearSearch(products, searchId);
                System.out.print("\nUsing Linear Search: ");
                break;
            
            case 2:
                result = binarySearch(products, searchId);
                System.out.print("\nUsing Binary Search: ");
                break;

            default:
                System.out.println("Invalid Choice!");
                sc.close();
                return;
        }

        if (result != null){
            System.out.println("Product Found !!\n");
            result.display();
        } else {
            System.out.println("Product Not Found !!");
        }

        System.out.println("\nSteps Taken by the algorithm: "+ steps);

        sc.close(); 
    }
}