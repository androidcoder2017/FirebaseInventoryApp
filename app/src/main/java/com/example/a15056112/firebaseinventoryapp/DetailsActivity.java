package com.example.a15056112.firebaseinventoryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DetailsActivity extends AppCompatActivity {

    private static final String TAG = "DetailsActivity";

    private EditText etName, etPrice;
    private Button btnUpdate, btnDelete;

    private Inventory inventory;

    private Inventory s;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference inventoryListRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        etName = (EditText)findViewById(R.id.editTextName);
        etPrice = (EditText)findViewById(R.id.editTextPrice);
        btnUpdate = (Button)findViewById(R.id.buttonUpdate);
        btnDelete = (Button)findViewById(R.id.buttonDelete);

        firebaseDatabase = FirebaseDatabase.getInstance();
        inventoryListRef = firebaseDatabase.getReference("/inventoryList");

        Intent intent = getIntent();
        inventory = (Inventory) intent.getSerializableExtra("Inventory");

        etName.setText(inventory.getName());
        etPrice.setText(String.valueOf(inventory.getPrice()));


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id = inventory.getId();
                s = new Inventory(etName.getText().toString(), Integer.parseInt(etPrice.getText().toString()), true);

                inventoryListRef.child(id).setValue(s);

                Toast.makeText(getApplicationContext(), "Inventory record updated successfully", Toast.LENGTH_SHORT).show();

                setResult(RESULT_OK);
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id = inventory.getId();

                //inventory.setId(null);
                inventoryListRef.child(id).removeValue();

                Toast.makeText(getApplicationContext(), "Inventory record deleted successfully", Toast.LENGTH_SHORT).show();

                setResult(RESULT_OK);
                finish();

            }
        });

    }
}
