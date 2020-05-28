package com.example.fit24;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "Kalori")
public class Kalori {
        @PrimaryKey
        @ColumnInfo(name = "KaloriId")
        @NonNull
        public int KaloriId = 0;

        @ColumnInfo(name = "YemekAdi")
        @NonNull
        public String YemekAdi;

        @ColumnInfo(name = "Kalorisi")
        @NonNull
        public int Kalorisi = 0;

        public Kalori(String YemekAdi) {this.YemekAdi = YemekAdi;}
        public Kalori(int Kalorisi) {this.Kalorisi = Kalorisi;}
        public String getAdi(){return this.YemekAdi;}
        public int getKalorisi(){return this.Kalorisi;}

}
