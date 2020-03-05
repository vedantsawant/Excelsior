package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private ArrayList<String> mfirno = new ArrayList<>();
    private ArrayList<String> mtime = new ArrayList<>();
    private ArrayList<String> mlocation = new ArrayList<>();
    private DataFragment mContext;
   public RecyclerViewAdapter(DataFragment context , ArrayList<String> firno , ArrayList<String> time , ArrayList<String> location){
       mfirno = firno;
       mtime = time;
       mlocation = location;
       mContext = context;
   }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent,false);
       ViewHolder viewHolder = new ViewHolder(view);
       return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.parentlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Toast toast = Toast.makeText(mContext.getContext(), mfirno.get(position), Toast.LENGTH_SHORT);
               toast.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mfirno.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView firno,time,location;
        RelativeLayout parentlayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            firno = itemView.findViewById(R.id.firno);
            time = itemView.findViewById(R.id.time);
            location = itemView.findViewById(R.id.location);

        }
    }
}
