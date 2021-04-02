package com.example.admin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AddressesFastFoodActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addressesfastfood);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_addressesFastFood);
        new FirebaseDatabaseHelper3().readAddresses(new FirebaseDatabaseHelper3.DataStatus() {
            @Override
            public void DataIsLoaded(List<AddressFastFood> addressesFastFood, List<String> keys) {
                new RecyclerView_Config3().setConfig(mRecyclerView, AddressesFastFoodActivity.this, addressesFastFood, keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });

    }
}
