package com.example.contactsapp.DI;

import android.content.Context;

import androidx.room.Room;

import com.example.contactsapp.data.repo.ContactsDaoRepository;
import com.example.contactsapp.room.ContactsDao;
import com.example.contactsapp.room.Database;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public ContactsDaoRepository providerContactsDaoRepository(ContactsDao cdao){
        return new ContactsDaoRepository(cdao);
    }
    @Provides
    @Singleton
    public ContactsDao provideContactsDao(@ApplicationContext Context context){
        Database db = Room.databaseBuilder(context, Database.class,"contacts.sqlite").createFromAsset("contacts.sqlite").build();
        return db.getContactsDao();
    }
}
