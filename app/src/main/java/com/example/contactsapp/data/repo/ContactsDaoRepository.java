package com.example.contactsapp.data.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.contactsapp.data.entity.Contacts;

import java.util.ArrayList;
import java.util.List;

public class ContactsDaoRepository {
    public MutableLiveData<List<Contacts>> contactList = new MutableLiveData<>();
    public void save(String person_name,String person_phone){
        Log.e("Save the person",person_name+" - "+person_phone);
    }
    public void update(int person_id,String person_name,String person_phone){
        Log.e("Update Contact",person_id+" - "+person_name+" - "+person_phone);
    }
    public void search(String search){
        Log.e("Search Contact",search);
    }
    public void delete(int person_id){
        Log.e("Delete Contact",String.valueOf(person_id));
        loadContacts();
    }
    public void loadContacts(){
        ArrayList<Contacts> list = new ArrayList<>();
        Contacts c1 = new Contacts(1,"Merthan","729649806");
        Contacts c2 = new Contacts(2,"Gabi","551963256");
        Contacts c3 = new Contacts(3,"Hehe","637489032");
        list.add(c1);
        list.add(c2);
        list.add(c3);
        contactList.setValue(list);
    }
}
