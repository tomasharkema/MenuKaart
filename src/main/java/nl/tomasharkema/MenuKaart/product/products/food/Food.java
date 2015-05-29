package nl.tomasharkema.menukaart.product.products.food;


import nl.tomasharkema.menukaart.product.Product;
import nl.tomasharkema.menukaart.units.Unit;

/**
 * Created by tomas on 28-05-15.
 */
class Food extends Product {
    Food(String name, double cost, double units, int calorie) {
        super(name, cost, Unit.Grams, units, calorie);
    }
}
