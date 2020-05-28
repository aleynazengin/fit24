package com.example.fit24;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KaloriListAdapter extends RecyclerView.Adapter<KaloriListAdapter.KaloriViewHolder> {

    class KaloriViewHolder extends RecyclerView.ViewHolder {
        private final TextView kaloriItemView;

        private KaloriViewHolder(View itemView) {
            super(itemView);
            kaloriItemView = itemView.findViewById(R.id.textViewitem);
        }
    }

    private final LayoutInflater mInflater;

    private List<Kalori> mKalori; // Cached copy of words

    KaloriListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public KaloriViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new KaloriViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(KaloriViewHolder holder, int position) {
        if (mKalori != null) {
            Kalori current = mKalori.get(position);
            holder.kaloriItemView.setText(current.getAdi());
            holder.kaloriItemView.setText(current.getKalorisi());
        } else {
            // Covers the case of data not being ready yet.
            holder.kaloriItemView.setText("Not found");
        }
    }

    void setWords(List<Kalori> kaloris){
        mKalori = kaloris;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mKalori != null)
            return mKalori.size();
        else return 0;
    }
}
