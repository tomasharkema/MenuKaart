package nl.tomasharkema.MenuKaart.utils;

import nl.tomasharkema.MenuKaart.MenuKaart;

import java.text.NumberFormat;

/**
 * Created by tomas on 28-05-15.
 */
public class StringUtils {

    /**
     * Formats the given price integer to a more human readable string. Conveniently wraps the NumberFormat class.
     * @param       price in any unit
     * @return      the more human readable string.
     */
    public static String formatPrice(double price) {
        return NumberFormat.getCurrencyInstance(MenuKaart.standardLocale).format(price);
    }

    /**
     * Repeat the given chararter n times
     * @param c         The char to repeat
     * @param times     The amount of repeating the char
     * @return          the generated string
     */
    public static String repeatChar(char c, int times) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
