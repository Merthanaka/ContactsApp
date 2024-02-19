package com.example.contactsapp.UI.ViewModel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.contactsapp.data.repo.ContactsDaoRepository;

public class RegisterViewModel extends ViewModel {
    public ContactsDaoRepository crepo = new ContactsDaoRepository();
    public void save(String person_name,String person_phone){
        crepo.save(person_name,person_phone);
    }
}
