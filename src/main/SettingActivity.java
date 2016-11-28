package com.example.birdfeed2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*import android.R;*/

/**
 * Created by Casey on 11/14/16.
 */

public class SettingActivity extends AppCompatActivity {

    private static int distance;
    private static HashMap<String, Boolean> restrict = new HashMap();
    private static int money;

    public static class User {
        User() {
            distance = 50;
            //restrict = null;
            int money = 5;
        }
        User(int d, HashMap<String, Boolean> r, int m) {
            distance = d;
            restrict = r;
            money = m;
        }
        public int getDist() { return distance; }
        public int getMoney() { return money; }
        public HashMap<String, Boolean> getRest() { return restrict; }

        public static void setRest(String s, Boolean flag) {
            restrict.put(s,flag);
            System.out.println("String: "+s+" Flag: "+flag);
        }
    }

    private static final String EXTRA_MESSAGE = "com.example.birdfeed2.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        User user = new User();
    }

    public void SearchDisplay(View view) {
        Intent intent = new Intent(this, SearchDisplay.class);
        EditText editText = (EditText) findViewById(R.id.searchText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkBox_nut:
                if (checked)
                    User.setRest("nut", true);
                else
                    User.setRest("nut", false);
                break;
            case R.id.checkBox_lactose:
                if (checked)
                    User.setRest("lactose", true);
                else
                    User.setRest("lactose", false);
                break;
            case R.id.checkBox_veggie:
                if (checked)
                    User.setRest("veggie", true);
                else
                    User.setRest("veggie", false);
                break;
        }
    }
}
