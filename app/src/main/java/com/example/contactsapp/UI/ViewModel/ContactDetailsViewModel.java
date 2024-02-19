package com.example.contactsapp.UI.ViewModel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.contactsapp.data.repo.ContactsDaoRepository;

public class ContactDetailsViewModel extends ViewModel {
    public ContactsDaoRepository crepo = new ContactsDaoRepository();
    public void update(int person_id,String person_name,String person_phone){
        crepo.update(person_id,person_name,person_phone);
    }
}
