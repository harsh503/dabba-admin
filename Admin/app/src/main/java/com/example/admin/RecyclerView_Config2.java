package com.example.admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_Config2 {

    private Context mContext;
    private AddressesAdapter mAddressesAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<Address> addresses, List<String> keys)
    {
        mContext  = context;
        mAddressesAdapter = new AddressesAdapter(addresses, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mAddressesAdapter);
    }

    class AddressItemView extends RecyclerView.ViewHolder
    {
        private TextView mDeliver;
        private TextView mPick;

        private String key;

        private AddressItemView(ViewGroup parent)
        {
            super(LayoutInflater.from(mContext).inflate(R.layout.address_list_item, parent, false));

            mDeliver = (TextView) itemView.findViewById(R.id.deliver_textView);
            mPick = (TextView) itemView.findViewById(R.id.pick_textView);
        }

        public void bind(Address address, String key)
        {
            mDeliver.setText("Deliver: " + address.getDeliver());
            mPick.setText("Pick: " + address.getPick());
            this.key = key;
        }
    }

    class AddressesAdapter extends RecyclerView.Adapter<AddressItemView>
    {
        private List<Address> mAddressList;
        private List<String> mKeys;

        public AddressesAdapter(List<Address> mAddressList, List<String> mKeys) {
            this.mAddressList = mAddressList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public AddressItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AddressItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull AddressItemView holder, int position) {
            holder.bind(mAddressList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mAddressList.size();
        }
    }

}
