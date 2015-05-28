package nl.tomasharkema.product.products.food;

import nl.tomasharkema.product.Product;
import nl.tomasharkema.units.Grams;
import nl.tomasharkema.units.Unit;

/**
 * Created by tomas on 28-05-15.
 */
public class Food extends Product {
    public Food(String name, double cost, double units, int calorie) {
        super(name, cost, new Grams(), units, calorie);
    }
}
