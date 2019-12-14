package com.example.cyf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SelectAdapter extends RecyclerView.Adapter<SelectAdapter.ViewHolder> {
    List<SelectBean> arrayList = null;
    MyOnClickListener myOnClickListener;

    public SelectAdapter(List<SelectBean> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_like_lable, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.isSelect = arrayList.get(position).isSelect;
        holder.cb.setText(arrayList.get(position).text);
        holder.cb.setChecked(holder.isSelect);
        if (myOnClickListener != null) {
            holder.cb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    myOnClickListener.OnClickIng(v, pos);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox cb;
        boolean isSelect;
        ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cb = itemView.findViewById(R.id.cb_item_likes);
            constraintLayout = itemView.findViewById(R.id.cl_item_root);
            isSelect = false;
        }
    }

    interface MyOnClickListener {
        void OnClickIng(View view, int pos);
    }

    public void setMyOnClickListener(MyOnClickListener myOnClickListener) {
        this.myOnClickListener = myOnClickListener;
    }
}
