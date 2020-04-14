package com.member.buybackbazaar.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Designed for storing settings
 */
public class AppPref {

    private static SharedPreferences prefs;

    public static void init(Application app) {
        prefs = app.getSharedPreferences("ekar_preference",
                Context.MODE_PRIVATE);
    }

    public static void putValueByKey(String key, Object value) {
        put(key, value);
    }

    public static String getStringByKey(String key) {
        return prefs.getString(key, "");
    }

    public static String getModificationDateByKey(String key) {
        return prefs.getString(key, "0000:00:00 00:00:00");
    }

    public static Boolean getBooleanByKey(String key) {
        return prefs.getBoolean(key, false);
    }

    public static Boolean getBooleanByKey(String key, boolean bool) {
        return prefs.getBoolean(key, bool);
    }

    public static Integer getIntegerByKey(String key) {
        return prefs.getInt(key, -1);
    }

    public static Float getFloatByKey(String key) {
        return prefs.getFloat(key, -1);
    }

    private static void put(String name, Object value) {
        SharedPreferences.Editor editor = prefs.edit();
        if (value.getClass() == Boolean.class) {
            editor.putBoolean(name, (Boolean) value);
        }
        if (value.getClass() == String.class) {
            editor.putString(name, String.valueOf(value));
        }
        if (value.getClass() == Integer.class) {
            //noinspection ConstantConditions
            editor.putInt(name, (Integer) value);
        }
        if (value.getClass() == Float.class) {
            //noinspection ConstantConditions
            editor.putFloat(name, (Float) value);
        }

        editor.apply();
    }

    public static void remove(String key) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.remove(key);
        editor.apply();
    }

    public static void clearAll() {
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.apply();
    }
}
