package nl.tomasharkema.MenuKaart.utils;

import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by tomas on 28-05-15.
 */
public class StringUtilsTest extends TestCase {

    public void testFormatPrice() throws Exception {
        assertThat("100 cents is € 1,00", StringUtils.formatPrice(1.00), is("€ 1,00"));
        assertThat("199 cents is € 1,99", StringUtils.formatPrice(1.99), is("€ 1,99"));
        assertThat("10000 cents is € 100,00", StringUtils.formatPrice(100.00), is("€ 100,00"));
    }
}