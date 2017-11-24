package com.example.hrp.birthday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1 , e2;
    Button b1,b2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        e1 = (EditText) findViewById(R.id.name);
        e2 = (EditText) findViewById(R.id.birthdya);
        b1 = (Button) findViewById(R.id.save);
        b2 = (Button) findViewById(R.id.show);

        final MyDbFunction mf = new MyDbFunction(getApplicationContext());

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String _name = e1.getText().toString();
                String _birthdya = e2.getText().toString();

                DataTemp dt = new DataTemp(_name, _birthdya);
                mf.addingDataToTable(dt);

                Toast.makeText(getApplicationContext(),"Add Data successfully ", Toast.LENGTH_LONG).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(getApplicationContext(),BirthdayFriend.class));
            }
        });

    }
}
