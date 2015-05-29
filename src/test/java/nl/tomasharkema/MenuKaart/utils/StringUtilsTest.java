package nl.tomasharkema.menukaart.utils;

import junit.framework.TestCase;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import static nl.tomasharkema.menukaart.utils.StringUtils.formatPrice;
import static nl.tomasharkema.menukaart.utils.StringUtils.repeatChar;

/**
 * Created by tomas on 28-05-15.
 */
public class StringUtilsTest extends TestCase {

    public void testFormatPrice() throws Exception {
        assertThat("100 cents is € 1,00", formatPrice(1.00), is("€ 1,00"));
        assertThat("199 cents is € 1,99", formatPrice(1.99), is("€ 1,99"));
        assertThat("10000 cents is € 100,00", formatPrice(100.00), is("€ 100,00"));
    }

    public void testRepeatChar() throws Exception {
        assertThat("10 dashes should be created", repeatChar('-', 10), is("----------"));
    }
}