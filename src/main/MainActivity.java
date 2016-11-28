package com.example.birdfeed2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
/*import android.R;*/

public class MainActivity extends AppCompatActivity {

    //Settings variables
    private int distance;
    private List<String> restrict = new ArrayList();
    private int money;

    public class User {
        User() {
            distance = 50;
            restrict = null;
            int money = 5;
        }
        User(int d, List r, int m) {
            distance = d;
            restrict = r;
            money = m;
        }
        public int getDist() { return distance; }
        public int getMoney() { return money; }
        public List getRest() { return restrict; }
    }

    public static final String EXTRA_MESSAGE = "com.example.birdfeed2.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void settings(View view) {
        Intent intent = new Intent(this, SettingActivity.class);
        intent.setAction(Intent.ACTION_MAIN);
        startActivity(intent);
    }

    public void FindActivity(View view) {
        Intent intent = new Intent(this, FindActivity.class);
        intent.setAction(Intent.ACTION_MAIN);
        startActivity(intent);
    }

    public void SearchByName(View view) {
        Intent intent = new Intent(this, SearchByName.class);
        intent.setAction(Intent.ACTION_MAIN);
        startActivity(intent);
        User user = new User();
    }

    public void SearchByCuisine(View view) {
        Intent intent = new Intent(this, SearchByName.class);
        intent.setAction(Intent.ACTION_MAIN);
        startActivity(intent);
    }

}
