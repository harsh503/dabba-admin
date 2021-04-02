package com.example.admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_Config4 {

    private Context mContext;
    private AddressesRestaurantAdapter mAddressesRestaurantAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<AddressRestaurant> addressesRestaurant, List<String> keys)
    {
        mContext  = context;
        mAddressesRestaurantAdapter = new AddressesRestaurantAdapter(addressesRestaurant, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mAddressesRestaurantAdapter);
    }

    class AddressRestaurantItemView extends RecyclerView.ViewHolder
    {
        private TextView mAddress;
        private TextView mNameAdd;
        private TextView mPhone;

        private String key;

        private AddressRestaurantItemView(ViewGroup parent)
        {
            super(LayoutInflater.from(mContext).inflate(R.layout.addressrestaurant_list_item, parent, false));

            mAddress = (TextView) itemView.findViewById(R.id.addressR_textView);
            mNameAdd = (TextView) itemView.findViewById(R.id.name_addR_textView);
            mPhone = (TextView) itemView.findViewById(R.id.phoneR_textView);
        }

        public void bind(AddressRestaurant addressRestaurant, String key)
        {
            mAddress.setText("Address: " + addressRestaurant.getAddress());
            mNameAdd.setText("Name: " + addressRestaurant.getName_add());
            mPhone.setText("Phone: " + addressRestaurant.getPhone());
            this.key = key;
        }
    }

    class AddressesRestaurantAdapter extends RecyclerView.Adapter<AddressRestaurantItemView>
    {
        private List<AddressRestaurant> mAddressRestaurantList;
        private List<String> mKeys;

        public AddressesRestaurantAdapter(List<AddressRestaurant> mAddressRestaurantList, List<String> mKeys) {
            this.mAddressRestaurantList = mAddressRestaurantList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public AddressRestaurantItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AddressRestaurantItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull AddressRestaurantItemView holder, int position) {
            holder.bind(mAddressRestaurantList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mAddressRestaurantList.size();
        }
    }

}
