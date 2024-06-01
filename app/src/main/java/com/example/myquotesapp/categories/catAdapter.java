package com.example.myquotesapp.categories;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myquotesapp.R;
import com.example.myquotesapp.myQuotes;

import java.util.List;

public class catAdapter extends RecyclerView.Adapter<catAdapter.MyViewHolder>{

    private final List<categoryList> catlist;

    public catAdapter(List<categoryList> catlist, Context context) {
        this.catlist = catlist;
        this.context = context;
    }

    private final Context context;

    @NonNull
    @Override
    public catAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_adapter_layout, null));
    }

    @Override
    public void onBindViewHolder(@NonNull catAdapter.MyViewHolder holder, int position) {
        categoryList list = catlist.get(position);

        holder.categoryName.setText(list.getCatName());
        holder.categoryImage.setImageResource(list.getCatImage());

        holder.categoryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (context, myQuotes.class);
                intent.putExtra("Category Name", list.getCatName());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return catlist.size();
    }
    static class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView categoryName;
        private final ImageView categoryImage;
        private final CardView categoryLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryName = itemView.findViewById(R.id.catName);
            categoryLayout = itemView.findViewById(R.id.catLayout);
            categoryImage = itemView.findViewById(R.id.catImage);
        }
    }
}
