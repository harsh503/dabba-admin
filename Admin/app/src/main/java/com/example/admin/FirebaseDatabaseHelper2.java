package com.example.admin;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper2 {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceAddresses;
    private List<Address> addresses = new ArrayList<>();

    public FirebaseDatabaseHelper2()
    {
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceAddresses = mDatabase.getReference("Address");
    }

    public interface DataStatus
    {
        void DataIsLoaded(List<Address> addresses, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public void readAddresses(final FirebaseDatabaseHelper2.DataStatus dataStatus)
    {
        mReferenceAddresses.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                addresses.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren())
                {
                    keys.add(keyNode.getKey());
                    Address address = keyNode.getValue(Address.class);
                    addresses.add(address);
                }
                dataStatus.DataIsLoaded(addresses, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
