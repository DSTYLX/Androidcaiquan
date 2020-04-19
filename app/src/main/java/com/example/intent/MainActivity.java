package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private Button button;

    private EditText editText = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("WrongViewCast")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,A_Activity.class);
                Bundle bundle = new Bundle();
                //TextView textView = (TextView) findViewById(R.id.username);
                editText = (EditText) findViewById(R.id.name);
                bundle.putString("name", String.valueOf(editText.getText().toString()));
                intent.putExtras(bundle);

                startActivity(intent);

            }
        });
    }


}


