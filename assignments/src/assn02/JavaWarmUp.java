package assn02;

import java.util.Scanner;
class transaction {
    String date;
    String time;
    String category;
    double price;
    int quantity;
    double rating;
    int duration;
    public transaction(String line){
        String[] attr = line.split(" ");
        date = attr[0];
        time = attr[1];
        category = attr[2];
        price = Double.parseDouble(attr[3]);
        quantity = Integer.parseInt(attr[4]);
        rating = Double.parseDouble(attr[5]);
        duration = Integer.parseInt(attr[6]);
    }
    public static transaction[] entries(Scanner insert){
        int len = Integer.parseInt(insert.nextLine());
        transaction[] all = new transaction[len];
        int i = 0;
        while(i < len){
            String next = insert.nextLine();
            all[i] = new transaction(next);
            i++;
        }
        return all;
    }
}
public class JavaWarmUp {
    public static void getMaxData(transaction[] data){
        transaction max = data[0];
        if(data.length == 1){
            System.out.println("Lowest per unit sale:");
        } else {
            int i = 0;
            while(i < data.length){
                if(data[i].price >= max.price){
                    max = data[i];
                }
                i++;
            }
            System.out.println("Highest per unit sale:");
        }
        System.out.println("\tWhen: " + max.date + " " + max.time);
        System.out.println("\tCategory: " + max.category);
        System.out.printf("\tPrice: %.2f", max.price);
        System.out.println("\n\tRating: " + max.rating);
    }
    public static void getMinData(transaction[] data){
        transaction min = data[0];
        if(data.length == 1){
            System.out.println("Lowest per unit sale:");
        } else {
            int i = 0;
            while(i < data.length){
                if(data[i].price <= min.price){
                    min = data[i];
                }
                i++;
            }
            System.out.println("Lowest per unit sale:");
        }
        System.out.println("\tWhen: " + min.date + " " + min.time);
        System.out.println("\tCategory: " + min.category);
        System.out.printf("\tPrice: %.2f", min.price);
        System.out.println("\n\tRating: " + min.rating);
    }
    public static void getAvgData(transaction[] data, String cat){
        int i = 0;
        int quantity = 0;
        double price = 0;
        double rating = 0;
        double duration = 0;
        int c = 0;
        while(c < data.length){
            if(data[c].category.equals(cat)){
                i += 1;
                quantity += data[c].quantity;
                price += data[c].price * data[c].quantity;
                rating += data[c].rating;
                duration += data[c].duration;
            }
            c++;
        }
        System.out.println("Averages by " + cat);
        System.out.println("\tQuantity: " + quantity);
        System.out.printf("\tPrice: %.2f\n", price / quantity);
        System.out.printf("\tRating: %.2f\n", rating / i);
        System.out.printf("\tDuration: %.2f\n", duration / i);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        transaction[] all_data = transaction.entries(in);
        getMaxData(all_data);
        getMinData(all_data);
        getAvgData(all_data, "book");
        getAvgData(all_data, "jewelry");
        getAvgData(all_data, "phone");
    }
}