package com.gelecek.fit24;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DiyetListAdapter extends RecyclerView.Adapter<DiyetListAdapter.DiyetViewHolder>{
    class DiyetViewHolder extends RecyclerView.ViewHolder {
        private final Button diyetItemView;
        private final TextView diyetTextView;



        private DiyetViewHolder(View itemView) {
            super(itemView);
            diyetItemView = itemView.findViewById(R.id.buttondiyetgetir);
            diyetTextView = itemView.findViewById(R.id.textViewdiyetitem);
        }
    }
    private int currentSelectedPosition = RecyclerView.NO_POSITION;
    private final LayoutInflater mInflater;

    private List<Diyet> mDiyet;
    private List<Boolean>showList;
    DiyetListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public DiyetListAdapter.DiyetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = mInflater.inflate(R.layout.diyet_recyclerview_item, parent, false);
        return new DiyetListAdapter.DiyetViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final DiyetListAdapter.DiyetViewHolder holder, final int position) {
        if (mDiyet != null) {
            Diyet current = mDiyet.get(position);
            holder.diyetItemView.setText(current.DİyetAdi);
            holder.diyetTextView.setText(current.DiyetAciklama + "");

        } else {
            // Covers the case of data not being ready yet.
            holder.diyetItemView.setText("Not found");
        }
        holder.diyetItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i=0;i>showList.size();i++){
                   if (showList.get(i) ==true){
                       Collections.fill(showList, Boolean.FALSE);
                   }
                }
                Boolean isSelected =showList.get(position);
                Boolean isSelectednot= !isSelected;
                showList.set(position, isSelectednot);
                notifyDataSetChanged();
            }

        });

        if (showList.get(position)){

            holder.diyetTextView.setVisibility(View.VISIBLE);
        }
        else {
            holder.diyetTextView.setVisibility(View.GONE);
        }
    }

    void setWords(List<Diyet> diyets) {
        mDiyet = diyets;
        showList=new ArrayList<Boolean>(Arrays.asList(new Boolean[mDiyet.size()]));
        Collections.fill(showList, Boolean.FALSE);

        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mDiyet != null)
            return mDiyet.size();
        else return 0;
    }
}
