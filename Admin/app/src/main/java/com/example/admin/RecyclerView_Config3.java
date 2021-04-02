package com.example.admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_Config3 {

    private Context mContext;
    private AddressesFastFoodAdapter mAddressesFastFoodAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<AddressFastFood> addressesFastFood, List<String> keys)
    {
        mContext  = context;
        mAddressesFastFoodAdapter = new AddressesFastFoodAdapter(addressesFastFood, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mAddressesFastFoodAdapter);
    }

    class AddressFastFoodItemView extends RecyclerView.ViewHolder
    {
        private TextView mAddress1;
        private TextView mNameAdd1;
        private TextView mPhone1;

        private String key;

        private AddressFastFoodItemView(ViewGroup parent)
        {
            super(LayoutInflater.from(mContext).inflate(R.layout.addressfastfood_list_item, parent, false));

            mAddress1 = (TextView) itemView.findViewById(R.id.address1_textView);
            mNameAdd1 = (TextView) itemView.findViewById(R.id.name_add1_textView);
            mPhone1 = (TextView) itemView.findViewById(R.id.phone1_textView);
        }

        public void bind(AddressFastFood addressFastFood, String key)
        {
            mAddress1.setText("Address: " + addressFastFood.getAddress1());
            mNameAdd1.setText("Name: " + addressFastFood.getName_add1());
            mPhone1.setText("Phone: " + addressFastFood.getPhone1());
            this.key = key;
        }
    }

    class AddressesFastFoodAdapter extends RecyclerView.Adapter<AddressFastFoodItemView>
    {
        private List<AddressFastFood> mAddressFastFoodList;
        private List<String> mKeys;

        public AddressesFastFoodAdapter(List<AddressFastFood> mAddressFastFoodList, List<String> mKeys) {
            this.mAddressFastFoodList = mAddressFastFoodList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public AddressFastFoodItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AddressFastFoodItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull AddressFastFoodItemView holder, int position) {
            holder.bind(mAddressFastFoodList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mAddressFastFoodList.size();
        }
    }

}
