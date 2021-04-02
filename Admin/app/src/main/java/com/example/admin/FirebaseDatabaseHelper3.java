package com.example.admin;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper3 {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceAddressesFastFood;
    private List<AddressFastFood> addressesFastFood = new ArrayList<>();

    public FirebaseDatabaseHelper3()
    {
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceAddressesFastFood = mDatabase.getReference("Address_Fast");
    }

    public interface DataStatus
    {
        void DataIsLoaded(List<AddressFastFood> addressesFastFood, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public void readAddresses(final FirebaseDatabaseHelper3.DataStatus dataStatus)
    {
        mReferenceAddressesFastFood.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                addressesFastFood.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren())
                {
                    keys.add(keyNode.getKey());
                    AddressFastFood addressFastFood = keyNode.getValue(AddressFastFood.class);
                    addressesFastFood.add(addressFastFood);
                }
                dataStatus.DataIsLoaded(addressesFastFood, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
