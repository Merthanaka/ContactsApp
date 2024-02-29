package com.example.contactsapp.room;

import androidx.room.RoomDatabase;

import com.example.contactsapp.data.entity.Contacts;

@androidx.room.Database(entities = {Contacts.class},version = 1)
public abstract class Database extends RoomDatabase {
    public abstract ContactsDao getContactsDao();


}
