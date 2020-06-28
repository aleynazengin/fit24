package com.gelecek.fit24;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Tuketim",foreignKeys = {
        @ForeignKey(
                entity = User.class,
                parentColumns = "UserId",
                childColumns = "UserId"
        ),
        @ForeignKey(
                entity = Kalori.class,
                parentColumns = "KaloriId",
                childColumns = "KaloriId"
        )})

public class Tuketim {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "TuketimId")
    @NonNull
    public int TuketimId = 0;


    @ColumnInfo(name = "UserId")
    @NonNull
    public int UserId = 0;

    @ColumnInfo(name = "KaloriId")
    @NonNull
    public int KaloriId = 0;

    @ColumnInfo(name = "Kalorisi")
    @NonNull
    public int Kalorisi = 0;

    @ColumnInfo(name = "Tarih")
    @NonNull
    public String Tarih;

    @ColumnInfo(name = "Ogun")
    @NonNull
    public int Ogun=0;

    @ColumnInfo(name = "KaloriYemekAdi")
    @NonNull
    public String KaloriYemekAdi;

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getKaloriId() {
        return KaloriId;
    }

    public void setKaloriId(int kaloriId) {
        KaloriId = kaloriId;
    }

    public int getKalorisi() {
        return Kalorisi;
    }

    public void setKalorisi(int kalorisi) {
        Kalorisi = kalorisi;
    }

    @NonNull
    public String getTarih() {
        return Tarih;
    }

    public void setTarih(@NonNull String tarih) {
        Tarih = tarih;
    }

    public int getOgun() {
        return Ogun;
    }

    public void setOgun(int ogun) {
        Ogun = ogun;
    }

    @NonNull
    public String getKaloriYemekAdi() {
        return KaloriYemekAdi;
    }

    public void setKaloriYemekAdi(@NonNull String kaloriYemekAdi) {
        KaloriYemekAdi = kaloriYemekAdi;
    }
}
