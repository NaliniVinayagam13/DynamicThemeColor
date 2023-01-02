package com.example.dynamicthemecolor.activities

import android.graphics.Color
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.dynamicthemecolor.R
import com.example.dynamicthemecolor.utils.Constants
import com.example.dynamicthemecolor.utils.ThemePreference
import kotlinx.android.synthetic.main.layout_action_bar.view.*

abstract class BaseActivity : AppCompatActivity() {

    lateinit var overallLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setContentView(layoutId: Int) {
        overallLayout = layoutInflater.inflate(R.layout.layout_action_bar, null) as LinearLayout
        var activityContainer: FrameLayout = overallLayout.findViewById(R.id.layout_container)
        layoutInflater.inflate(layoutId, activityContainer, true)
        initViews()
        super.setContentView(overallLayout)
    }

    private fun initViews() {
        overallLayout.toolbar.setBackgroundColor(Color.parseColor(ThemePreference.getThemeColor(this)))
        window.statusBarColor = Color.parseColor(ThemePreference.getStatusBarColor(this))

        val mCons = Constants()
        mCons.setTextColor(this, overallLayout.toolbar.text_back)
        mCons.setTextColor(this, overallLayout.toolbar.custom_title)
    }

}