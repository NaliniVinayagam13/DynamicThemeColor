package com.example.dynamicthemecolor.activities

import android.os.Bundle
import com.example.dynamicthemecolor.R
import kotlinx.android.synthetic.main.layout_action_bar.*

class SecondActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initViews()
    }

    private fun initViews(){
        custom_title.text = "SecondScreen"
    }

}