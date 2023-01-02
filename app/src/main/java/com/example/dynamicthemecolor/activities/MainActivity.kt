package com.example.dynamicthemecolor.activities

import android.content.Intent
import android.graphics.Color.parseColor
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.example.dynamicthemecolor.R
import com.example.dynamicthemecolor.utils.Constants
import com.example.dynamicthemecolor.utils.ThemePreference
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_action_bar.*
import kotlinx.android.synthetic.main.layout_action_bar.view.*


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setupEvents()
    }

    private fun initViews(){
        custom_title.text = "MainScreen"
    }

    private fun setupEvents(){

        etxtToolBarColr.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val prefix = "#"
                val count = s?.toString()?.length ?: 0
                if (count < prefix.length) {
                    if (s.toString() != prefix.trim()) {
                        etxtToolBarColr.setText("$prefix$s")
                    } else {
                        etxtToolBarColr.setText(prefix)
                    }
                    etxtToolBarColr.setSelection(etxtToolBarColr.length())
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        changeThemeButton.setOnClickListener {

//            ThemePreference.setStatusBarColor(this, etxtStatusBarColr.text.toString())

            try {
                window.statusBarColor = parseColor(etxtToolBarColr.text.toString())
                toolbar.setBackgroundColor(parseColor(etxtToolBarColr.text.toString()))
                img_sample.setColorFilter(parseColor(etxtToolBarColr.text.toString()))
                changeThemeButton.setBackgroundColor(parseColor(etxtToolBarColr.text.toString()))
                replaceFragmentBtn.setBackgroundColor(parseColor(etxtToolBarColr.text.toString()))
                ThemePreference.setThemeColor(this, etxtToolBarColr.text.toString());

                val mCons = Constants()
                mCons.setTextColor(this, overallLayout.toolbar.text_back)
                mCons.setTextColor(this, overallLayout.toolbar.custom_title)
                mCons.setTextColor(this, changeThemeButton)
            }catch (e: Exception){
                Toast.makeText(this, "Invalid Color Code", Toast.LENGTH_SHORT).show()
            }

//            val col = parseColor(ThemePreference.getThemeColor(this))
//            val darkness: Double =
//                1 - (0.299 * Color.red(col) + 0.587 * Color.green(col) + 0.114 * Color.blue(
//                    col
//                )) / 255
//            if (darkness < 0.25) { // Bg is light
//                Log.d("Main", "Bg is Light")
//                overallLayout.toolbar.text_back.isSelected = false
//                overallLayout.toolbar.custom_title.isSelected = false
//                changeThemeButton.isSelected = false
//            } else { // bg is dark
//                Log.d("Main", "Bg is dark")
//                changeThemeButton.isSelected = true
//                overallLayout.toolbar.text_back.isSelected = true
//                overallLayout.toolbar.custom_title.isSelected = true
//            }
        }

        text_back.setOnClickListener{
            startActivity(Intent(this, SecondActivity::class.java))
        }

        replaceFragmentBtn.setOnClickListener{
            startActivity((Intent(this, BaseFragmentActivity::class.java)))
        }
    }
}
