package com.example.birdfeed2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

/**
 * Created by Casey on 11/18/16.
 */

public class FindActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_activity);

        Intent intent = getIntent();
        ViewGroup layout = (ViewGroup) findViewById(R.id.find_activity);
    }
}
