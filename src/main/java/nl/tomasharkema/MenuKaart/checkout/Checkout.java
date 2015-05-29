package nl.tomasharkema.menukaart.checkout;

import nl.tomasharkema.menukaart.product.Printable;
import nl.tomasharkema.menukaart.product.Product;
import nl.tomasharkema.menukaart.utils.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tomas on 28-05-15.
 */
public class Checkout implements Serializable {

    private final Product[] listOfProducts;
    private final String beginMessage;
    private final String endMessage;

    private Checkout(Product[] listOfProducts, String beginMessage, String endMessage) {
        this.listOfProducts = listOfProducts;
        this.beginMessage = beginMessage;
        this.endMessage = endMessage;
    }

    /**
     * Get the total costs from the products.
     * @return double of all the costs
     */
    private double getTotalCosts() {
        int costs = 0;

        for (Product p : listOfProducts) {
            costs += p.getCosts();
        }

        return costs;
    }

    /**
     * Create a string from the products. This is in a generic bill format
     * @return String of the bill
     */
    public String getBillString() {
        StringBuilder bill = new StringBuilder();

        int width = 0;

        bill.append(beginMessage);
        bill.append("\n\n");

        for (Printable p : listOfProducts) {
            final String productString = p.print();
            bill.append(productString);
            bill.append("\n");

            int stringWidth = productString.length();

            if (stringWidth > width) width = stringWidth;
        }

        bill.append(StringUtils.repeatChar('-', width));
        bill.append("\n\n");

        bill.append("Total: ");
        bill.append(StringUtils.formatPrice(getTotalCosts()));
        bill.append("\n\n");

        bill.append(endMessage);
        bill.append("\n");

        return bill.toString();
    }

    /**
     * Writes the bill to a file. Filename specified by the filename parameter
     * @param filename Name of file to be written to
     * @throws IOException
     */
    public void writeBillToFile(String filename) throws IOException {
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(filename));
        stream.writeObject(this);
        stream.close();
    }

    /**
     * Read the bill from a specified file.
     * @param filename Name of the file to be read.
     * @return String of the bill from the file.
     * @throws IOException
     */
    public Checkout readBillFromFile(String filename) throws Exception {
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream(filename));
        return (Checkout)stream.readObject();
    }

    /**
     * Build upon the immutable Checkout class. Handy for when the client changes her mind!
     * @return A new builder instance from the Checkout instance.
     */
    public Builder buildUpon() {
        Builder builder = new Builder();
        builder.beginMessage = beginMessage;
        builder.endMessage = endMessage;

        builder.addProducts(listOfProducts);

        return builder;
    }

    @Override
    public String toString() {
        return "Checkout{" +
                "listOfProducts=" + Arrays.toString(listOfProducts) +
                ", beginMessage='" + beginMessage + '\'' +
                ", endMessage='" + endMessage + '\'' +
                '}';
    }

    /**
     * Builder for the more final Checkout class. Modify here, keep there.
     */
    public static final class Builder {
        private List<Product> addProducts = new ArrayList<>();

        private String beginMessage = "";
        private String endMessage = "";

        /**
         * Add a product to the products array
         * @param product product to be added.
         * @return the same instance as this method is called on.
         */
        public Builder addProduct(Product product) {
            addProducts.add(product);
            return this;
        }

        /**
         * Add multiple products to the products array
         * @param products array of products
         * @return the same instance as this method is called on.
         */
        public Builder addProducts(Product... products) {
            for (Product p : products) {
                addProduct(p);
            }
            return this;
        }

        /**
         * Set the endMessage that will be printed tailing the bill
         * @param endMessage
         */
        public void setEndMessage(String endMessage) {
            this.endMessage = endMessage;
        }

        /**
         * Set the beginMessage that will be printed on top of the bill
         * @param beginMessage
         */
        public void setBeginMessage(String beginMessage) {
            this.beginMessage = beginMessage;
        }

        /**
         * Sort the product array on calories, depending on the sort-strategy
         * @param sortStrategie ASC or DESC
         * @return the same instance as this method is called on.
         */
        public Builder sortOnCalories(SortStrategy sortStrategie) {
            addProducts = addProducts.stream()
                    .sorted((o1, o2) -> sortStrategie.value * (int) (o1.getCalories() - o2.getCalories()))
                    .collect(Collectors.toList());
            return this;
        }

        /**
         * Build the Checkout class;
         * @return the builded Checkout class.
         */
        public Checkout build() {
            return new Checkout(addProducts.toArray(new Product[addProducts.size()]),
                    beginMessage,
                    endMessage);
        }
    }

    /**
     * Enum used to provide the correct sorting strategy.
     */
    public enum SortStrategy {
        ASC(1),
        DESC(-1);

        public final int value;

        SortStrategy(int value) {
            this.value = value;
        }
    }

}
