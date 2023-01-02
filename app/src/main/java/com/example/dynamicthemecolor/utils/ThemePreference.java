package com.example.dynamicthemecolor.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class ThemePreference {

	private static final String THEME_COLOR = "THEME_COLOR";
	private static final String STATUS_BAR_COLOR = "STATUS_BAR_COLOR";

	public static SharedPreferences getSharedPreferences(Context ctx) {
		return PreferenceManager.getDefaultSharedPreferences(ctx);
	}

	public static void setThemeColor(Context ctx, String accessToken) {
		Editor editor = getSharedPreferences(ctx).edit();
		editor.putString(THEME_COLOR, accessToken);
		editor.commit();
	}
	public static String getThemeColor(Context ctx) {
		return getSharedPreferences(ctx).getString(THEME_COLOR, "#123456");
	}

//	public static void setStatusBarColor(Context ctx, String userId) {
//		Editor editor = getSharedPreferences(ctx).edit();
//		editor.putString(STATUS_BAR_COLOR, userId);
//		editor.commit();
//	}
//	public static String getStatusBarColor(Context ctx) {
//		return getSharedPreferences(ctx).getString(STATUS_BAR_COLOR, "#D81B60");
//	}
}
