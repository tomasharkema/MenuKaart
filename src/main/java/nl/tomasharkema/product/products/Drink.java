package nl.tomasharkema.product.products;

import nl.tomasharkema.product.Product;
import nl.tomasharkema.units.Liters;
import nl.tomasharkema.units.Unit;

/**
 * Created by tomas on 28-05-15.
 */
public abstract class Drink extends Product {
    public Drink(String name, double cost, double units, int calorie) {
        super(name, cost, new Liters(), units, calorie);
    }
}
