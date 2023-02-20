package com.example.onlineshoppingbs23.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.onlineshoppingbs23.data.local.dao.UserDao;
import com.example.onlineshoppingbs23.data.local.entity.UserEntity;

@Database(entities = {UserEntity.class} ,version = 1)
public abstract class AppDatabase  extends RoomDatabase {

    public  abstract UserDao userDao();

    private  static final  String DB_NAME = "shop.db";

    private static  AppDatabase appDatabase;

    public  static  synchronized AppDatabase getInstance(Context context){
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return  appDatabase;
    }
}
