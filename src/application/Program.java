package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Roberto
 */
public class Program {

    public static void main(String[] args) throws ParseException{
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Product> list = new ArrayList<>();

        
        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();
        
        for (int i = 1 ; i <= n ; i++){
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/d/i)? ");
            char c = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();
            
            switch (c){
                case 'c':
                    list.add(new Product(name,price));
                    break;
                case 'u':
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    System.out.print("Manufacture date (DD/MM/YYYY): ");
                    Date manufactureDate = sdf.parse(sc.next());
                    list.add(new UsedProduct(name, price ,manufactureDate));
                    break;
                case 'i':
                    System.out.print("Custom fee: ");
                    Double customFee = sc.nextDouble();
                    list.add(new ImportedProduct(name,price,customFee));
                    break;
            }
        }
        
        System.out.println("\nPRICE TAGS:");
        for(Product c : list){
            System.out.println(c.priceTag());
        }
        
        sc.close();
    }
   
}