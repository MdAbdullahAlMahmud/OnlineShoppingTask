package com.example.onlineshoppingbs23.data.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class UserEntity {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "phone")
    public String phone;

     @ColumnInfo(name = "password")
    public String password;

     @ColumnInfo(name =  "role")
    public  int role;



}
