package com.example.a15056112.firebaseinventoryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddActivity extends AppCompatActivity {

    private static final String TAG = "AddActivity";

    private EditText etName, etPrice;
    private Button btnAdd;
    private Inventory inventory;

    // TODO: Task 1 - Declare Firebase variables
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference inventoryListRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etName = (EditText)findViewById(R.id.editTextName);
        etPrice = (EditText)findViewById(R.id.editTextPrice);
        btnAdd = (Button)findViewById(R.id.buttonAdd);

        // TODO: Task 2: Get Firebase database instance and reference
        firebaseDatabase = FirebaseDatabase.getInstance();
        inventoryListRef = firebaseDatabase.getReference("/inventoryList");

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                int price = Integer.parseInt(etPrice.getText().toString());

                inventory = new Inventory(name,price, true);

                inventoryListRef.push().setValue(inventory);

                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);

            }
        });

    }
}
