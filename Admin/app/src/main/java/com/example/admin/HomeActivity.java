package com.example.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    Button users_button, address_button, addressFastFood_button, addressRestaurant_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        users_button = (Button) findViewById(R.id.users_button);
        users_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent users_intent = new Intent (v.getContext(), UsersActivity.class);
                startActivity(users_intent);
            }
        });

        address_button = (Button) findViewById(R.id.address_button);
        address_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent address_intent = new Intent (v.getContext(), AddressesActivity.class);
                startActivity(address_intent);
            }
        });

        addressFastFood_button = (Button) findViewById(R.id.addressFastFood_button);
        addressFastFood_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addressFastFood_intent = new Intent (v.getContext(), AddressesFastFoodActivity.class);
                startActivity(addressFastFood_intent);
            }
        });

        addressRestaurant_button = (Button) findViewById(R.id.addressRestaurant_button);
        addressRestaurant_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addressRestaurant_intent = new Intent (v.getContext(), AddressesRestaurantActivity.class);
                startActivity(addressRestaurant_intent);
            }
        });
    }
}
