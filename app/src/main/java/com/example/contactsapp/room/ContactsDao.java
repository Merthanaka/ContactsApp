package com.example.contactsapp.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.contactsapp.data.entity.Contacts;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface ContactsDao {
    @Query("SELECT * FROM contacts")
    Single<List<Contacts>> loadContacts();
    @Insert
    Completable save(Contacts contacts);
    @Update
    Completable update(Contacts contacts);
    @Delete
    Completable delete(Contacts contacts);
    @Query("SELECT * FROM contacts WHERE person_name like '%' || :searchWord || '%'")
    Single<List<Contacts>> search(String searchWord);

}
