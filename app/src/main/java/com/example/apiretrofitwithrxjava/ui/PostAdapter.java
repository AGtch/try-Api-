package com.example.apiretrofitwithrxjava.ui;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apiretrofitwithrxjava.R;
import com.example.apiretrofitwithrxjava.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private List<PostModel> postModelList = new ArrayList<>();

    @NonNull
    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PostAdapter.PostViewHolder holder, int position) {
        holder.titleTxtView.setText(postModelList.get(position).getTitle());
        holder.userTxtView.setText(postModelList.get(position).getUserId() + "");
        holder.bodyTxtView.setText(postModelList.get(position).getBody());
    }

    public void setList(List<PostModel> postModelList) {
        this.postModelList = postModelList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return postModelList.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        TextView titleTxtView, userTxtView, bodyTxtView;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTxtView = itemView.findViewById(R.id.title_txt);
            userTxtView = itemView.findViewById(R.id.user_id_txt);
            bodyTxtView = itemView.findViewById(R.id.body_txt);

        }
    }
}


