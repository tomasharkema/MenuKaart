package nl.tomasharkema.menukaart.product;


import nl.tomasharkema.menukaart.units.Unit;
import nl.tomasharkema.menukaart.utils.StringUtils;

/**
 * Created by tomas on 28-05-15.
 */
public abstract class Product implements Printable {

    /**
     * The name of the product
     */
    private final String name;

    /**
     * The price of the product, in cents, per unit.
     */
    private final double cost;

    /**
     * The type unit this product comes in.
     */
    private final Unit unit;

    /**
     * The amount of units of the product. In baseunits.
     */
    private final double units;

    /**
     * The amout of calories per unit
     */
    private final int calorie;

    /**
     * Get the cost of the product, from the amout of units and the costs.
     * @return double of costs
     */
    public double getCosts() {
        return cost * units;
    }

    /**
     * Get the amount of calories from the amount of calories and the units.
     * @return double of calories
     */
    public double getCalories() {
        return calorie * units;
    }

    /**
     * Construct a Product Object.
     * @param name      Name of product
     * @param cost      Cost of product (per unit)
     * @param unit      Unit of product
     * @param units     Amount of units of product
     * @param calorie   Amount of calories per unit.
     */
    protected Product(String name, double cost, Unit unit, double units, int calorie) {
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.units = units;
        this.calorie = calorie;
    }

    @Override
    public String print() {
        return name + " (" + units + " " + unit.abbriviation + ") " + StringUtils.formatPrice(getCosts());
    }
}
