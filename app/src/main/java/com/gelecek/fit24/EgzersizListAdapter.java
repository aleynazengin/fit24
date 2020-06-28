package com.gelecek.fit24;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class EgzersizListAdapter extends RecyclerView.Adapter<EgzersizListAdapter.EgzersizViewHolder> {
    class EgzersizViewHolder extends RecyclerView.ViewHolder{
        private final ImageView egzImage;
        private final TextView egzAdi;

        private EgzersizViewHolder(View itemView) {
            super(itemView);
            egzImage=itemView.findViewById(R.id.egzImage);
            egzAdi=itemView.findViewById(R.id.egzAdi);

        }
    }

    private final LayoutInflater mEInflater;

    private List<Egzersiz> mEgzersiz;

    EgzersizListAdapter(Context context) {
        mEInflater = LayoutInflater.from(context);
    }

    @Override
    public EgzersizListAdapter.EgzersizViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = mEInflater.inflate(R.layout.recycle_egzersiz, parent, false);
        return new EgzersizViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final EgzersizViewHolder holder, int position) {
        if (mEgzersiz != null) {
            Egzersiz current = mEgzersiz.get(position);
            holder.egzAdi.setText(current.EgzersizAdi);
            try
            {
                InputStream ims = holder.itemView.getContext().getAssets().open(current.EgzersizImage);
                Drawable d = Drawable.createFromStream(ims, null);
                // set image to ImageView
                holder.egzImage.setImageDrawable(d);
                ims.close();
            }
            catch(IOException ex)
            {

            }
        }
            else {
                holder.egzAdi.setText("Not found");
            }


        }

    void setWords(List<Egzersiz> egzersizs) {
        mEgzersiz = egzersizs;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if (mEgzersiz != null)
            return mEgzersiz.size();
        else return 0;
    }


}
