package com.kodevian.ejemplo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        final Firebase myFirebaseRef = new Firebase("https://crackling-fire-4441.firebaseio.com/");
        final Map<String,String> row = new HashMap<String,String>();
        row.put("field","more data");

        setContentView(R.layout.activity_main);

        Button clickButton = (Button) findViewById(R.id.button);
        clickButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Toast toast = Toast.makeText(getApplicationContext(),"Enviando mensaje", Toast.LENGTH_LONG);
               myFirebaseRef.child("message").push().setValue(row);
                toast.show();
            }
        });
    }
}
