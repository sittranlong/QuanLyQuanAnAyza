/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Format;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 * @author sangtm
 */
public class Formater {  
    public static String formatVND(Object o) {
        Locale l = new Locale("vi", "VN");
        NumberFormat nf = NumberFormat.getCurrencyInstance(l);
        return nf.format(o);
    }
    
    public static String formatDate(String format, Object o) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(o);
    }
}
