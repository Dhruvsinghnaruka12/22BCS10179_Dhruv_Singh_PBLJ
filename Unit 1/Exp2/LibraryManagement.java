package First_Unit.Exp2;

import java.util.Scanner;


class Book {
    protected String title;
    protected String author;
    protected double price;

    
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}


class Fiction extends Book {
    public Fiction(String title, String author, double price) {
        super(title, author, price);
    }
    
    @Override
    public void displayDetails() {
        System.out.println("Type: Fiction");
        super.displayDetails();
    }
}


class NonFiction extends Book {
    public NonFiction(String title, String author, double price) {
        super(title, author, price);
    }
    
    @Override
    public void displayDetails() {
        System.out.println("Type: Non-Fiction");
        super.displayDetails();
    }
}


public class LibraryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter Book Type (Fiction/NonFiction): ");
        String type = scanner.nextLine();

        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Author: ");
        String author = scanner.nextLine();

        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();

        Book book;
        if (type.equalsIgnoreCase("Fiction")) {
            book = new Fiction(title, author, price);
        } else {
            book = new NonFiction(title, author, price);
        }

        System.out.println("\nBook Details:");
        book.displayDetails();
        
        scanner.close();
    }
}