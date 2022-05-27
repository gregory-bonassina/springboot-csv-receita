package com.dbserver.sincronizacaoreceita.util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * @author Gregory Bonassina
 */
public class NumberUtilities {

    private static NumberFormat format = NumberFormat.getInstance(Locale.getDefault());

    /**
     * isNumeric
     * 
     * @param str
     * @return
     * @throws ParseException
     */
    public static double formatToDouble(String str) throws ParseException {
        return format.parse(str).doubleValue();
    }
}
