package nl.tomasharkema.menukaart.units;

/**
 * Created by tomas on 28-05-15.
 */
public enum Unit {
    Liters("Liter", "L"),
    Grams("Gram", "g");

    public final String name;
    public final String abbriviation;

    Unit(String name, String abbriviation) {
        this.name = name;
        this.abbriviation = abbriviation;
    }
}