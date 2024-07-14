package com.coding.dynasty.android_studio_course_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.Viewholder> {
    ArrayList<CoursesDomain> items;
    Context context;

    public CoursesAdapter(ArrayList<CoursesDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CoursesAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflator = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_list, parent, false);
        context = parent.getContext();
        return new Viewholder(inflator);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CoursesAdapter.Viewholder holder, int position) {
        holder.title.setText(items.get(position).getTitle());
        holder.price.setText("$" + items.get(position).getPrice());


        @SuppressLint("DiscouragedApi") int drawableResourceId = holder.itemView.getResources()
                .getIdentifier(items.get(position).getPicPath(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(context)
                .load(drawableResourceId)
                .into(holder.pic);

        switch (position) {
            case 0:
                holder.background_img.setImageResource(R.drawable.bg_1);
                holder.layout.setBackgroundResource(R.drawable.list_background_1);
                break;
            case 1:
                holder.background_img.setImageResource(R.drawable.bg_2);
                holder.layout.setBackgroundResource(R.drawable.list_background_2);
                break;
            case 2:
                holder.background_img.setImageResource(R.drawable.bg_3);
                holder.layout.setBackgroundResource(R.drawable.list_background_3);
                break;
            case 3:
                holder.background_img.setImageResource(R.drawable.bg_4);
                holder.layout.setBackgroundResource(R.drawable.list_background_4);
                break;
            case 4:
                holder.background_img.setImageResource(R.drawable.bg_5);
                holder.layout.setBackgroundResource(R.drawable.list_background_5);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder {
        TextView title, price;
        ImageView pic, background_img;
        ConstraintLayout layout;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleTxt);
            price = itemView.findViewById(R.id.priceTxt);
            pic = itemView.findViewById(R.id.pic);
            background_img = itemView.findViewById(R.id.background_img);
            layout = itemView.findViewById(R.id.mail_layout);
        }
    }
}
