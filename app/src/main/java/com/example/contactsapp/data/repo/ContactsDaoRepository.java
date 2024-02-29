package com.example.contactsapp.data.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.contactsapp.data.entity.Contacts;
import com.example.contactsapp.room.ContactsDao;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ContactsDaoRepository {
    public MutableLiveData<List<Contacts>> contactList = new MutableLiveData<>();
    private ContactsDao cdao;
    public ContactsDaoRepository(ContactsDao cdao){
        this.cdao = cdao;
    }
    public void save(String person_name,String person_phone){
        Contacts newcontact = new Contacts(0,person_name,person_phone);
        cdao.save(newcontact).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
    public void update(int person_id,String person_name,String person_phone){
        Contacts contact = new Contacts(person_id,person_name,person_phone);
        cdao.update(contact).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onComplete() {}
                    @Override
                    public void onError(Throwable e) {}
                });
    }
    public void search(String search){
        cdao.search(search).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<List<Contacts>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(List<Contacts> contacts) {
                contactList.setValue(contacts);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
    public void delete(int person_id){

        Contacts contact = new Contacts(person_id,"","");
        cdao.delete(contact).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onComplete() {
                        loadContacts();}
                    @Override
                    public void onError(Throwable e) {}
                });

    }
    public void loadContacts(){
       cdao.loadContacts().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<List<Contacts>>() {
           @Override
           public void onSubscribe(Disposable d) {

           }

           @Override
           public void onSuccess(List<Contacts> contacts) {
            contactList.setValue(contacts);
           }

           @Override
           public void onError(Throwable e) {

           }
       });
    }
}
