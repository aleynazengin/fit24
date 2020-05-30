package com.example.fit24;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity(tableName = "Diyet",foreignKeys = {
        @ForeignKey(
                entity = User.class,
                parentColumns = "UserId",
                childColumns = "UserId"
        )})

public class Diyet {
    @PrimaryKey
    @ColumnInfo(name = "DiyetId")
    @NonNull
    public int DiyetId = 0;


    @ColumnInfo(name = "UserId")
    @NonNull
    public int UserId = 0;

    @ColumnInfo(name = "DiyetAdi")
    @NonNull
    public String DİyetAdi;

    @ColumnInfo(name = "DiyetAciklama")
    @NonNull
    public String DiyetAciklama;

    @ColumnInfo(name = "DiyetImage")

    public String DiyetImage;

    @ColumnInfo(name = "DiyetKalorisi")
    @NonNull
    public int DiyetKalorisi = 0;
}
