package com.example.franklinmauricio.materialdesign;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


/**
 * Created by FranklinMauricio on 22/05/2015.
 */
public class VivzAdapter extends RecyclerView.Adapter<VivzAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private  ClickListener clickListener;
    List<Information> data= Collections.emptyList();
    public  VivzAdapter(Context context,List<Information> data){
        inflater=LayoutInflater.from(context);
        this.data=data;
        this.context=context;

    }
    public void delete(int position){
        data.remove(position);
        notifyItemRemoved(position);


    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= inflater.inflate(R.layout.custom_row, parent, false);
        MyViewHolder holder=new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Information current=data.get(position);
        holder.title.setText(current.title);
        holder.icon.setImageResource(current.iconId);

    }
    public void setClickListener(ClickListener clickListener){
        this.clickListener=clickListener;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        ImageView icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title=(TextView)itemView.findViewById(R.id.listText);
            icon =(ImageView)itemView.findViewById(R.id.listIcon);


        }

        @Override
        public void onClick(View v) {

        }
    }
    public interface ClickListener{
        public void itemClicked(View view,int position);
    }
}
