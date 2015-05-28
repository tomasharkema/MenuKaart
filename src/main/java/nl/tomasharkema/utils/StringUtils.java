package nl.tomasharkema.utils;

import nl.tomasharkema.MenuKaart;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by tomas on 28-05-15.
 */
public class StringUtils {

    /**
     * Formats the given price integer to a more human readable string. Conviently wraps the NumberFormat class.
     * @param price in any unit
     * @return the more human readable string.
     */
    public static String formatPrice(double price) {
        return NumberFormat.getCurrencyInstance(MenuKaart.standardLocale).format(price);
    }

    public static String repeatChar(char c, int times) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
