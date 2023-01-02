package com.example.dynamicthemecolor.widgets;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dynamicthemecolor.utils.ThemePreference;

public class CustomImageView extends androidx.appcompat.widget.AppCompatImageView {

    public CustomImageView(@NonNull Context context) {
        super(context);
    }

    public CustomImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomImageView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setImageDrawable(@Nullable Drawable drawable) {
        drawable.setTint(Color.parseColor(ThemePreference.getThemeColor(getContext())));
        super.setImageDrawable(drawable);
    }
}
