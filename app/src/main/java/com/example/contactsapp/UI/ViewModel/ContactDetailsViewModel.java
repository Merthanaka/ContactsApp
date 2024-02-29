package com.example.contactsapp.UI.ViewModel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.contactsapp.data.repo.ContactsDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ContactDetailsViewModel extends ViewModel {
    public ContactsDaoRepository crepo;
    @Inject
    public ContactDetailsViewModel(ContactsDaoRepository crepo){
        this.crepo=crepo;
    }
    public void update(int person_id,String person_name,String person_phone){
        crepo.update(person_id,person_name,person_phone);
    }
}
