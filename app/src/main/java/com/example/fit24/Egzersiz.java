package com.example.fit24;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Egzersiz",foreignKeys = {
        @ForeignKey(
                entity = User.class,
                parentColumns = "UserId",
                childColumns = "UserId"
        )})
public class Egzersiz {
    @PrimaryKey
    @ColumnInfo(name = "EgzersizId")
    @NonNull
    public int EgzersizId = 0;

    @ColumnInfo(name = "UserId")
    @NonNull
    public int UserId = 0;

    @ColumnInfo(name = "EgzersizAdi")
    @NonNull
    public String EgzersizAdi;

    @ColumnInfo(name = "EgzersizImage")

    public String EgzersizImage;

    @ColumnInfo(name = "EgzersizAciklama")
    @NonNull
    public String EgzersizAciklama;

    @ColumnInfo(name = "EgzersizKalorisi")
    @NonNull
    public int EgzersizKalorisi = 0;
}
