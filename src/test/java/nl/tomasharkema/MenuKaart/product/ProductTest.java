package nl.tomasharkema.menukaart.product;

import nl.tomasharkema.menukaart.product.products.drinks.Cola;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Created by tomas on 28-05-15.
 */
public class ProductTest {

    private Product getStandardProduct() {
        return new Cola(0.2);
    }

    @Test
    public void testGetCosts() throws Exception {
        assertThat("Cost should be correct", getStandardProduct().getCosts(), is(2.0));
    }

    @Test
    public void testGetCalories() throws Exception {
        assertThat("Calories should be correct", getStandardProduct().getCosts(), is(2.0));
    }

    @Test
    public void testPrint() throws Exception {
        assertThat("Print output should be correct", getStandardProduct().print(), is("Coca Cola (0.2 L) € 2,00"));
    }
}