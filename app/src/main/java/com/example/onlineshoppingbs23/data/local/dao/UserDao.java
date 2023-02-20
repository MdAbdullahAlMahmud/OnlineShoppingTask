package com.example.onlineshoppingbs23.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.onlineshoppingbs23.data.local.entity.UserEntity;

import java.util.List;

@Dao
public interface UserDao {

   /* @Query("Insert into users VALUES((:name),:phone,:password)")
    void createUserAccount(String name, String phone, String password);*/


    @Insert
    void  insertUser(UserEntity user);

    @Query("select * from users")
    List<UserEntity> getAllUser();

    @Query("select uid from users where phone  LIKE :mobile AND password LIKE :pass")
    int  login(String mobile , String pass );
}
