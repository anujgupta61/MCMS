package com.andromap33.mcms;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class AppSharedPreference {
    static final String PREF_FLAG = "flag";
    static final String PREF_TODAY_MENU = "today_menu";
    static final String PREF_PRICE = "price";

    static SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static void setFlag(Context ctx, Boolean flag) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putBoolean(PREF_FLAG , flag);
        editor.commit();
    }


    public static void setTodayMenu(Context ctx, String today_menu) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PREF_TODAY_MENU , today_menu);
        editor.commit();
    }

    public static void setPrice(Context ctx, String price) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PREF_PRICE , price);
        editor.commit();
    }

    public static Boolean getFlag(Context ctx) {
        return getSharedPreferences(ctx).getBoolean(PREF_FLAG , false);
    }

    public static String getTodayMenu(Context ctx) {
        return getSharedPreferences(ctx).getString(PREF_TODAY_MENU , "");
    }

    public static String getPrice(Context ctx) {
        return getSharedPreferences(ctx).getString(PREF_PRICE , "");
    }
}