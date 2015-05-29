package nl.tomasharkema.menukaart;

import nl.tomasharkema.menukaart.checkout.Checkout;
import nl.tomasharkema.menukaart.product.products.drinks.Cola;
import nl.tomasharkema.menukaart.product.products.food.Pizza;
import nl.tomasharkema.menukaart.product.products.food.Spaghetti;

import java.io.IOException;

class Main {

    public static void main(String[] args) {

        Checkout.Builder bill = new Checkout.Builder();

        bill.addProduct(new Spaghetti(300))
            .addProduct(new Cola(0.2))
            .addProduct(new Pizza(400));

        bill.beginMessage = "Welkom bij 'Restaurant 't Boontje'";
        bill.endMessage = "Tot ziens!";

        Checkout checkout = bill.build();

        System.out.println(checkout.getBillString());

        // ------------------
        // Sort on calories
        // ------------------

        final Checkout.Builder sortBuilder = checkout.buildUpon();
        sortBuilder.sortOnCalories(Checkout.SortStrategy.DESC);
        checkout = sortBuilder.build();
        System.out.println(checkout.getBillString());
        System.out.println("\n\n\n");

        // ------------------
        // Test write to file
        // ------------------

        try {
            checkout.writeBillToFile("bill.txt");
            System.out.println("Bill written to file!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("Read bill from file");
        try {
            String billString = checkout.readBillFromFile("bill.txt");
            System.out.println("Got a bill for ya!\n\n" + billString);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
