package com.example.dynamicthemecolor.widgets;

import static android.graphics.Color.parseColor;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;

import com.example.dynamicthemecolor.utils.Constants;
import com.example.dynamicthemecolor.utils.ThemePreference;

public class CustomButton extends androidx.appcompat.widget.AppCompatButton {

	public CustomButton(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public CustomButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setBackgroundDrawable(Drawable d) {
		d.setTint(parseColor(ThemePreference.getThemeColor(getContext())));
		Constants mCons = new Constants();
		mCons.setTextColor(getContext(), this);
		AutoButtonBg bgLayer = new AutoButtonBg(d);
		super.setBackgroundDrawable(bgLayer);
	}

	protected class AutoButtonBg extends LayerDrawable {
		protected ColorFilter _pressedFilter;
		protected int _disabledAlpha = 100;
		public AutoButtonBg(Drawable d) {
			super(new Drawable[] { d });
			_pressedFilter = new LightingColorFilter(0xCC808080, 0x000000);
		}

		@Override
		protected boolean onStateChange(int[] states) {
			boolean enabled = false;
			boolean pressed = false;
			for (int state : states){

				if (state == android.R.attr.state_enabled){
					enabled = true;
				}
				else if (state == android.R.attr.state_pressed){
					pressed = true;
				}
			}

			mutate();
			if (enabled && pressed) {
				setColorFilter(_pressedFilter);
			} else if (!enabled) {
				setColorFilter(null);
				setAlpha(_disabledAlpha);
			} else {
				setColorFilter(null);
			}

			invalidateSelf();
			return super.onStateChange(states);
		}

		@Override
		public boolean isStateful() {
			return true;
		}
	}
}
