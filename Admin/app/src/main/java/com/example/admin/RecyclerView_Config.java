package com.example.admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_Config {

    private Context mContext;
    private UsersAdapter mUsersAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<Users> users, List<String> keys)
    {
        mContext = context;
        mUsersAdapter = new UsersAdapter(users, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mUsersAdapter);
    }

    class UsersItemView extends RecyclerView.ViewHolder
    {
        private TextView mId;
        private TextView mName;
        private TextView mPhone;

        private String key;

        public UsersItemView(ViewGroup parent)
        {
            super(LayoutInflater.from(mContext).inflate(R.layout.users_list_item, parent, false));

            mId = (TextView) itemView.findViewById(R.id.id_textView);
            mName = (TextView) itemView.findViewById(R.id.name_textView);
            mPhone = (TextView) itemView.findViewById(R.id.phone_textView);
        }

        public void bind(Users user, String key)
        {
            mId.setText(user.getId());
            mName.setText(user.getName());
            mPhone.setText(""+user.getPhone());
            this.key = key;
        }
    }

    class UsersAdapter extends RecyclerView.Adapter<UsersItemView>
    {
        private List<Users> mUsersList;
        private List<String> mKeys;

        public UsersAdapter(List<Users> mUsersList, List<String> mKeys) {
            this.mUsersList = mUsersList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public UsersItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new UsersItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull UsersItemView holder, int position) {
            holder.bind(mUsersList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mUsersList.size();
        }
    }

}
