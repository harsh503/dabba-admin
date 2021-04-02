package com.example.admin;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper4 {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceAddressesRestaurant;
    private List<AddressRestaurant> addressesRestaurant = new ArrayList<>();

    public FirebaseDatabaseHelper4()
    {
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceAddressesRestaurant = mDatabase.getReference("Address_restora");
    }

    public interface DataStatus
    {
        void DataIsLoaded(List<AddressRestaurant> addressesRestaurant, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public void readAddresses(final FirebaseDatabaseHelper4.DataStatus dataStatus)
    {
        mReferenceAddressesRestaurant.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                addressesRestaurant.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren())
                {
                    keys.add(keyNode.getKey());
                    AddressRestaurant addressRestaurant = keyNode.getValue(AddressRestaurant.class);
                    addressesRestaurant.add(addressRestaurant);
                }
                dataStatus.DataIsLoaded(addressesRestaurant, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
