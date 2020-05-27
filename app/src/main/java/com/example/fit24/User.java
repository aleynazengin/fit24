package com.example.fit24;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "User")
public class User {
    @PrimaryKey
    @ColumnInfo(name = "UserId")
    @NonNull
    public int Id = 0;

    @ColumnInfo(name = "Username")
    @NonNull
    public String Username;

    @ColumnInfo(name = "Password")
    @NonNull
    public String Password;

    @ColumnInfo(name = "Email")
    @NonNull
    public String Email;

    @ColumnInfo(name = "Name")
    @NonNull
    public String Name;

    @ColumnInfo(name = "SurName")
    @NonNull
    public String Surname;

    @ColumnInfo(name = "Height")
    @NonNull
    public int Height = 0;

    @ColumnInfo(name = "Age")
    @NonNull
    public int Age = 0;

    @ColumnInfo(name = "Cinsiyet")
    @NonNull
    public int Gender = 0;

    @ColumnInfo(name = "Weight")
    @NonNull
    public int Weight = 0;

    @ColumnInfo(name = "Goal")
    @NonNull
    public int Goal = 0;

    @ColumnInfo(name = "Reactivity")
    @NonNull
    public int Reactivity = 0;

}
