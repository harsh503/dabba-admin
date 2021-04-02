package com.example.admin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class
AddressesRestaurantActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addressesrestaurant);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_addressesRestaurant);
        new FirebaseDatabaseHelper4().readAddresses(new FirebaseDatabaseHelper4.DataStatus() {
            @Override
            public void DataIsLoaded(List<AddressRestaurant> addressesRestaurant, List<String> keys) {
                new RecyclerView_Config4().setConfig(mRecyclerView, AddressesRestaurantActivity.this, addressesRestaurant, keys);
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
