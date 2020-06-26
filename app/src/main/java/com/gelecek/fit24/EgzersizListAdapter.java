package com.gelecek.fit24;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class EgzersizListAdapter extends RecyclerView.Adapter<EgzersizListAdapter.EgzersizViewHolder> {
    class EgzersizViewHolder extends RecyclerView.ViewHolder{
        private final ImageView egzImage;
        private final ImageView egzImage1;
        private final ImageView egzImage2;
        private final TextView egzAdi;
        private final TextView egzAciklama;

        private EgzersizViewHolder(View itemView) {
            super(itemView);
            egzImage=itemView.findViewById(R.id.egzImage);
            egzAdi=itemView.findViewById(R.id.egzAdi);
            egzImage1=itemView.findViewById(R.id.egzImage1);
            egzImage2=itemView.findViewById(R.id.egzImage2);
            egzAciklama=itemView.findViewById(R.id.egzAciklama);

        }
    }
    private int currentSelectedPosition = RecyclerView.NO_POSITION;

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
            holder.egzAciklama.setText(current.EgzersizAciklama);
            try
            {
                InputStream ims = holder.itemView.getContext().getAssets().open(current.EgzersizImage);
                InputStream egz = holder.itemView.getContext().getAssets().open(current.Image1);
                InputStream egz2 = holder.itemView.getContext().getAssets().open(current.Image2);
                Drawable d = Drawable.createFromStream(ims, null);
                Drawable b =Drawable.createFromStream(egz,null);
                Drawable f =Drawable.createFromStream(egz2,null);
                // set image to ImageView
                holder.egzImage.setImageDrawable(d);
                holder.egzImage1.setImageDrawable(b);
                holder.egzImage2.setImageDrawable(f);

                ims.close();
                egz.close();
                egz2.close();
            }
            catch(IOException ex)
            {

            }
        }
            else {
                holder.egzAdi.setText("Not found");
            }

        holder.egzImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentSelectedPosition = holder.getAdapterPosition();
                notifyDataSetChanged();
            }
        });


            if (currentSelectedPosition == position) {
                if (holder.egzImage.getVisibility()==View.VISIBLE)
                {
                    holder.egzImage1.setVisibility(View.VISIBLE);
                    holder.egzImage2.setVisibility(View.VISIBLE);
                    holder.egzAciklama.setVisibility(View.VISIBLE);
                }
                else {
                   
                }

            } else {
                holder.egzImage1.setVisibility(View.GONE);
                holder.egzImage2.setVisibility(View.GONE);
                holder.egzAciklama.setVisibility(View.GONE);
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
