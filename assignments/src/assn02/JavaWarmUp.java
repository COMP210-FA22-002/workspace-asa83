package assn02;
import java.util.Scanner;

class transIndex {
    String date;
    String time;
    String category;
    double price;
    int quantity;
    double rating;
    int duration;
    public transIndex(String input) {
        date = input.substring(0, input.indexOf(" "));
        input = input.substring(input.indexOf(" ") + 1);
        time = input.substring(0, input.indexOf(" "));
        input = input.substring(input.indexOf(" ") + 1);
        category = input.substring(0, input.indexOf(" "));
        input = input.substring(input.indexOf(" ") + 1);
        price = Double.parseDouble(input.substring(0, input.indexOf(" ")));
        input = input.substring(input.indexOf(" ") + 1);
        quantity = Integer.parseInt(input.substring(0, input.indexOf(" ")));
        input = input.substring(input.indexOf(" ") + 1);
        rating = Double.parseDouble(input.substring(0, input.indexOf(" ")));
        input = input.substring(input.indexOf(" ") + 1);
        duration = Integer.parseInt(input);
    }
    public static transIndex[] tArray(Scanner input){
        int size = Integer.parseInt(input.nextLine());
        transIndex[] df = new transIndex[size];
        for (int i = 0; i < size; i++){
            String elt = input.nextLine();
            df[i] = new transIndex(elt);
        }
        return df;
    }
}

public class JavaWarmUp {

        public static void highLow(transIndex ti) {
            System.out.println("\tWhen: " + ti.date + " " + ti.time);
            System.out.println("\tCategory: " + ti.category);
            System.out.println("\tPrice: " + ti.price);
            System.out.println("\tRating" + ti.quantity);
        }

        public static void getMaxPrice(transIndex[] dt) {
            if (dt.length == 1) {
                System.out.println("Highest per unit sale: ");
                highLow(dt[0]);
            } else {
                transIndex max = dt[0];
                for (int i = 1; i < dt.length; i++) {
                    if (dt[i].price <= max.price) {
                        max = dt[i];
                    }
                }
                System.out.println("Highest per unit sale: ");
                highLow(max);
            }
        }

        public static void getMinPrice(transIndex[] dt) {
            if (dt.length == 1) {
                System.out.println("Lowest per unit sale: ");
                highLow(dt[0]);
            } else {
                transIndex min = dt[0];
                for (int i = 1; i < dt.length; i++) {
                    if (dt[i].price <= min.price) {
                        min = dt[i];
                    }
                }
                System.out.println("Lowest per unit sale: ");
                highLow(min);
            }
        }

        public static void transAvg(transIndex[] dt, String tp) {
            if (dt.length == 0) {
                System.out.println("None");
            } else {
                int i = 0;
                int quantity = 0;
                double price = 0;
                double rating = 0;
                double duration = 0;
                for (transIndex ti : dt) {
                    if (ti.category.equals(tp)) {
                        i += 1;
                        quantity += ti.quantity;
                        price += ti.price;
                        rating += ti.rating;
                        duration += ti.duration;
                    }
                }
                System.out.println("Averages by " + tp);
                System.out.println("\tQuantity: " + quantity);
                System.out.printf("\tPrice: %.2f\n", price / quantity);
                System.out.printf("\tRating: %.2f\n", rating / i);
                System.out.printf("\tDuration: %.2f\n", duration / i);
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            transIndex[] t = transIndex.tArray(sc);
            getMaxPrice(t);
            getMinPrice(t);
            transAvg(t, "book");
            transAvg(t, "jewelry");
            transAvg(t, "phone");
        }
}
