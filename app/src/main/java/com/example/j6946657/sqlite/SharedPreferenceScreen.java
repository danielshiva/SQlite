package com.example.j6946657.sqlite;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SharedPreferenceScreen extends AppCompatActivity {

    EditText userNameFld;
    EditText passwordFld;
    Button saveBtn;
    Button displayBtn;
    TextView displayUserName;
    TextView displayPwdName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference_screen);

        // References
        userNameFld = (EditText) findViewById(R.id.userNameFld);
        passwordFld = (EditText) findViewById(R.id.passwordFld);
        saveBtn = (Button) findViewById(R.id.saveBtn);
        displayBtn = (Button) findViewById(R.id.displayBtn);
        displayUserName = (TextView) findViewById(R.id.displayUserName);
        displayPwdName = (TextView) findViewById(R.id.displayPwdName);
    }

    // Save Details
    public void saveDetails(View view){
        SharedPreferences sharedPref = getSharedPreferences("UserDetails", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("username", userNameFld.getText().toString());
        editor.putString("password", passwordFld.getText().toString());
        editor.apply();

        Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();
    }

    // Display Details
    public void displayDetails(View view){
        SharedPreferences sharedPref = getSharedPreferences("UserDetails", Context.MODE_PRIVATE);

        String username = sharedPref.getString("username", "");
        String password = sharedPref.getString("password", "");

        displayUserName.setText(username);
        displayPwdName.setText(password);
    }

}
