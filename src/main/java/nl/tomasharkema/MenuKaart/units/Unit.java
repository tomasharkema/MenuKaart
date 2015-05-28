package nl.tomasharkema.MenuKaart.units;

/**
 * Created by tomas on 28-05-15.
 */
public abstract class Unit {

    public final String name;
    public final String abbriviation;

    public Unit(String name, String abbriviation) {
        this.name = name;
        this.abbriviation = abbriviation;
    }
}
