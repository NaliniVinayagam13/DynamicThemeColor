package com.example.dynamicthemecolor.activities;

import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.example.dynamicthemecolor.R;
import com.example.dynamicthemecolor.fragments.FirstFragment;

public class BaseFragmentActivity extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_base_fragment);
        initViews();
    }

    private void initViews(){
        TextView title = (TextView) findViewById(R.id.custom_title);
        title.setText("FirstFragment");
        replaceFragments();
    }

    public void replaceFragments(){
        getSupportFragmentManager().beginTransaction().add(R.id.layout_frame, new FirstFragment()).commit();
    }

}
