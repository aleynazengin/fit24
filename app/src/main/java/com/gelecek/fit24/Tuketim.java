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
    @PrimaryKey
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
}
