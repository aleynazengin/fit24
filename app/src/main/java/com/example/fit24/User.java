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

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @NonNull
    public String getUsername() {
        return Username;
    }

    public void setUsername(@NonNull String username) {
        Username = username;
    }

    @NonNull
    public String getPassword() {
        return Password;
    }

    public void setPassword(@NonNull String password) {
        Password = password;
    }

    @NonNull
    public String getEmail() {
        return Email;
    }

    public void setEmail(@NonNull String email) {
        Email = email;
    }

    @NonNull
    public String getName() {
        return Name;
    }

    public void setName(@NonNull String name) {
        Name = name;
    }

    @NonNull
    public String getSurname() {
        return Surname;
    }

    public void setSurname(@NonNull String surname) {
        Surname = surname;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getGender() {
        return Gender;
    }

    public void setGender(int gender) {
        Gender = gender;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    public int getGoal() {
        return Goal;
    }

    public void setGoal(int goal) {
        Goal = goal;
    }

    public int getReactivity() {
        return Reactivity;
    }

    public void setReactivity(int reactivity) {
        Reactivity = reactivity;
    }
}
