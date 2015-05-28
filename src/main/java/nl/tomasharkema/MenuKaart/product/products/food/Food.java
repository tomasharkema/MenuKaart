package nl.tomasharkema.MenuKaart.product.products.food;


import nl.tomasharkema.MenuKaart.product.Product;
import nl.tomasharkema.MenuKaart.units.Grams;

/**
 * Created by tomas on 28-05-15.
 */
class Food extends Product {
    Food(String name, double cost, double units, int calorie) {
        super(name, cost, new Grams(), units, calorie);
    }
}
