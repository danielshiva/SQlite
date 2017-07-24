package com.example.j6946657.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText productName;
    TextView displayProduct;
    MyDBHandler dbHandler;

    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // for Camera task
        nextBtn = (Button) findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CameraScreen.class);
                startActivity(i);
            }
        });

        // for SQlite task
        productName = (EditText) findViewById(R.id.productsName);
        displayProduct = (TextView) findViewById(R.id.displayProducts);
        dbHandler = new MyDBHandler(this, null, null, 1);

        // Print DB values
        printValues();
    }

    // Add products
    public void addBtnClicked(View view){
        Log.d("Inside :--","Addbtn");
        Products product = new Products(productName.getText().toString());
        dbHandler.addProduct(product);
        printValues();
    }

    //Delete products
    public void deleteBtnClicked(View view){
        Log.d("Inside :--","DeleteBtn");
        String inputText = productName.getText().toString();
        dbHandler.deleteProduct(inputText);
        printValues();
    }

    // Print values
    public void printValues(){
        Log.d("Inside :--","PrintVal");
        String dbString = dbHandler.printDBValues();
        displayProduct.setText(dbString);
        productName.setText("");
    }
}
