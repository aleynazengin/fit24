package com.example.fit24;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Tuketim")
public class Tuketim {
    @PrimaryKey
    @ColumnInfo(name = "TüketimId")
    @NonNull
    public int TüketimId = 0;


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
}
