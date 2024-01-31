package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import static java.time.LocalDate.parse;

public class Main {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat SDFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("running");

        List<Product> list = new ArrayList<>();

        System.out.println("Enter the number of products: ");
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            System.out.println("Product #"+(i+1)+" data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            String opt = sc.next();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Price: ");
            Double price = sc.nextDouble();
            switch (opt){
                case "c":
                    list.add(new Product(name,price));
                    break;
                case "i":
                    System.out.print("Customs fee: ");
                    double customsFee = sc.nextDouble();
                    list.add(new ImportedProduct(name,price,customsFee));
                    break;
                case "u":
                    System.out.print("Manufacture date (DD/MM/YYYY): ");
                    String date = sc.next();
                    list.add(new UsedProduct(name, price,SDFormat.parse(date)));
                    break;
                default:
                    System.out.println("Nenhuma opção encontrada");
                    break;
            }
        }
        System.out.println("PRICE TAGS: ");
        for (Product product : list){
            System.out.println(product.priceTag());
        }
        sc.close();
    }
}
