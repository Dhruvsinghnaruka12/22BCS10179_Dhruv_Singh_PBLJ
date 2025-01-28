package First_Unit.Exp2;

/*Write a Java program to create a Product class
with attributes id, name, and price. The program should:
Demonstrate the use of constructors and methods to display
product details
Input Example:
Product ID: 101
Name: Laptop
Price: 75000 */
import java.util.Scanner;


class Product {
    private int id;
    private String name;
    private double price;

    
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    
    public void displayProductDetails() {
        System.out.println("Product Details:");
        System.out.println("Product ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}


public class ProductDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();
        
       
        Product product = new Product(id, name, price);
        
      
        product.displayProductDetails();
        
        scanner.close();
    }
}
