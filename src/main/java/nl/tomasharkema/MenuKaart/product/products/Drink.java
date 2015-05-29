package nl.tomasharkema.menukaart.product.products;


import nl.tomasharkema.menukaart.product.Product;
import nl.tomasharkema.menukaart.units.Unit;

/**
 * Created by tomas on 28-05-15.
 */
public abstract class Drink extends Product {
    protected Drink(String name, double cost, double units, int calorie) {
        super(name, cost, Unit.Liters, units, calorie);
    }
}
