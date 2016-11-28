package com.example.birdfeed2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import static com.example.birdfeed2.MainActivity.EXTRA_MESSAGE;

/**
 * Created by Casey on 11/18/16.
 */

public class SearchByName extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);

        Intent intent = getIntent();
        ViewGroup layout = (ViewGroup) findViewById(R.id.search_activity);
    }

    public void SearchDisplay(View view) {
        Intent intent = new Intent(this, SearchDisplay.class);
        EditText editText = (EditText) findViewById(R.id.searchText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}
