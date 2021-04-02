package com.example.admin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AddressesActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addresses);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_addresses);
        new FirebaseDatabaseHelper2().readAddresses(new FirebaseDatabaseHelper2.DataStatus() {
            @Override
            public void DataIsLoaded(List<Address> addresses, List<String> keys) {
                new RecyclerView_Config2().setConfig(mRecyclerView, AddressesActivity.this, addresses, keys);
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
