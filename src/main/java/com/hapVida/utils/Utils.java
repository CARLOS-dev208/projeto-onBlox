package com.hapVida.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static String getString(Object obj) {
        if (obj == null) {
            return null;
        } else {
            return String.valueOf(obj);
        }
    }

    public static Long getLong(Object obj) {
        if (obj == null) {
            return null;
        } else {
            return Long.valueOf(String.valueOf(obj));
        }
    }

    public static String formataData(Date data, String format) {

        if (data == null) {
            return null;
        } else {

            SimpleDateFormat formato = new SimpleDateFormat(format);
            return formato.format(data);
        }
    }

    public static double getDouble(Object obj) {
        if (obj == null) {
            return 0;
        } else {
            return Double.valueOf(String.valueOf(obj));
        }
    }

    public static Date getDate(Object obj) {
        if (obj==null) {
            return null;
        }else {
            return (Date) obj;
        }
    }
}
