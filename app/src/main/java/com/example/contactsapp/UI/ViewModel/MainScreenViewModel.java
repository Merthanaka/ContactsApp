package com.example.contactsapp.UI.ViewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.contactsapp.data.entity.Contacts;
import com.example.contactsapp.data.repo.ContactsDaoRepository;

import java.util.ArrayList;
import java.util.List;

public class MainScreenViewModel extends ViewModel {
    public ContactsDaoRepository mrepo = new ContactsDaoRepository();
    public MutableLiveData<List<Contacts>> contactList;

    public MainScreenViewModel(){
        loadContacts();
        contactList = mrepo.contactList;
    }

    public void search(String search){
        mrepo.search(search);
    }
    public void delete(int person_id){
        mrepo.delete(person_id);
    }
    public void loadContacts(){
        mrepo.loadContacts();
    }
}
