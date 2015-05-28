package nl.tomasharkema.MenuKaart.checkout;

import junit.framework.TestCase;
import nl.tomasharkema.MenuKaart.product.products.drinks.Cola;
import nl.tomasharkema.MenuKaart.product.products.drinks.Fanta;
import nl.tomasharkema.MenuKaart.product.products.food.Pizza;
import nl.tomasharkema.MenuKaart.product.products.food.Spaghetti;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

import static org.hamcrest.core.Is.is;
/**
 * Created by tomas on 28-05-15.
 */
public class CheckoutTest {

    private final static String testFileName = "testFile.txt";

    @After
    public void tearDown() throws Exception {

        // remove testfile
        final File file = new File(testFileName);
        file.delete();
    }

    private static Matcher<String> standardMatcher() {
            return is(
                    "Welkom bij 'Restaurant 't Boontje'\n" +
                    "\n" +
                    "Coca Cola (0.2 L) € 2,00\n" +
                    "Spaghetti (300.0 g) € 9,90\n" +
                    "Pizza (400.0 g) € 8,80\n" +
                    "--------------------------\n" +
                    "\n" +
                    "Total: € 19,00\n" +
                    "\n" +
                    "Tot ziens!" +
                    "\n");
    }

    private Checkout createStandardCheckout() {
        Checkout.Builder bill = new Checkout.Builder();

        bill.addProduct(new Cola(0.2))
            .addProduct(new Spaghetti(300))
            .addProduct(new Pizza(400));

        bill.beginMessage = "Welkom bij 'Restaurant 't Boontje'";
        bill.endMessage = "Tot ziens!";

       return bill.build();
    }

    @Test
    public void testGetBillString() throws Exception {
        final Checkout checkout = createStandardCheckout();
        assertThat("getBillString should return the correct bill.", checkout.getBillString(),
                standardMatcher());
    }

    @Test
    public void testWriteBillToFile() throws Exception {
        final Checkout checkout = createStandardCheckout();

        checkout.writeBillToFile(testFileName);

        assertThat("File is written correctly", checkout.readBillFromFile(testFileName), standardMatcher());
    }

    @Test
    public void testBuildUpon() throws Exception {
        final Checkout checkout = createStandardCheckout();
        final Checkout.Builder buildUpon = checkout.buildUpon();

        buildUpon.addProduct(new Fanta(0.3));

        assertThat("Build upon should update the checkout bill", buildUpon.build().getBillString(), is(
                "Welkom bij 'Restaurant 't Boontje'\n" +
                "\n" +
                "Coca Cola (0.2 L) € 2,00\n" +
                "Spaghetti (300.0 g) € 9,90\n" +
                "Pizza (400.0 g) € 8,80\n" +
                "Fanta (0.3 L) € 2,70\n" +
                "--------------------------\n" +
                "\n" +
                "Total: € 21,00\n" +
                "\n" +
                "Tot ziens!\n"));
    }
}