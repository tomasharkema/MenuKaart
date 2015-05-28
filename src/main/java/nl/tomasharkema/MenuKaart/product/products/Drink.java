package nl.tomasharkema.MenuKaart.product.products;


import nl.tomasharkema.MenuKaart.product.Product;
import nl.tomasharkema.MenuKaart.units.Liters;

/**
 * Created by tomas on 28-05-15.
 */
public abstract class Drink extends Product {
    protected Drink(String name, double cost, double units, int calorie) {
        super(name, cost, new Liters(), units, calorie);
    }
}
