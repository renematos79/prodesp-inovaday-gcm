package br.com.prodesp.inovadaygcm;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ConvertHelper {

    public static String ToString(CharSequence c)
    {
        try
        {
            return c.toString();
        }
        catch (Exception ex)
        {
            return "";
        }
    }

    public static String ToString(double value, int decimalPlaces)
    {
        if (decimalPlaces <= 0) decimalPlaces = 2;
        Locale locale = new Locale("pt", "BR");
        NumberFormat numberFormat = DecimalFormat.getInstance(locale);
        numberFormat.setMaximumFractionDigits(decimalPlaces);
        return numberFormat.format(value);
    }

    public static int ToInt(CharSequence c)
    {
        try
        {
            if (c ==  null)
            {
                return 0;
            }
            return Integer.parseInt(c.toString());
        }
        catch (Exception ex)
        {
            return 0;
        }
    }

    public static double ToDouble(CharSequence c)
    {
        try
        {
            if (c ==  null)
            {
                return 0;
            }
            return Double.parseDouble(c.toString());
        }
        catch (Exception ex)
        {
            return 0;
        }
    }

    public static double ToDouble(String value)
    {
        try
        {
            Locale locale = new Locale("pt", "BR");
            NumberFormat numberFormat = DecimalFormat.getInstance(locale);
            Number number = numberFormat.parse(value);
            return number.doubleValue();
        }
        catch (Exception ex)
        {
            return 0;
        }
    }

    public static String ToString(Date value, String fmt)
    {
        return new SimpleDateFormat(fmt).format(value);
    }

    public static String ToString(Date value)
    {
        return ToString(value, "dd/MM/yyyy");
    }

    public static Date ToDate(String value)
    {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try
        {
            return format.parse(value);
        }
        catch (Exception ex) {
            return null;
        }
    }
}
