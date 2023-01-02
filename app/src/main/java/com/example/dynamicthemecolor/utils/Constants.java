package com.example.dynamicthemecolor.utils;

import static android.graphics.Color.parseColor;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;

public class Constants {

    public void setTextColor(Context ctxt, View view) {
        int col = parseColor(ThemePreference.getThemeColor(ctxt));
        Double darkness = 1 - (0.299 * Color.red(col) + 0.587 * Color.green(col) + 0.114 * Color.blue(col)) / 255;
        if(darkness< 0.25) { // Bg is light
            Log.d("Constants", "Bg is Light");
            view.setSelected(false);
        } else { // bg is dark
            Log.d("Constants", "Bg is dark");
            view.setSelected(true);
        }
    }
}
