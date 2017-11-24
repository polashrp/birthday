package com.example.hrp.birthday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BirthdayFriend extends AppCompatActivity {

    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday_friend);

        textView = (TextView) findViewById(R.id.showData);

        MyDbFunction mf = new MyDbFunction(getApplicationContext());

        String[] data =  mf.myData();

        String s = "";
        for (int i=0; i < data.length; i++){
            s = s+data[i]+ "\n\n";
        }
        textView.setText(s);

       // textView.setText(data[1]);
    }
}
