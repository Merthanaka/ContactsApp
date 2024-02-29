package com.example.contactsapp.UI.ViewModel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.contactsapp.data.repo.ContactsDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class RegisterViewModel extends ViewModel {
    public ContactsDaoRepository crepo;
    @Inject
    public RegisterViewModel(ContactsDaoRepository crepo) {
        this.crepo = crepo;
    }

    public void save(String person_name, String person_phone){
        crepo.save(person_name,person_phone);
    }
}
