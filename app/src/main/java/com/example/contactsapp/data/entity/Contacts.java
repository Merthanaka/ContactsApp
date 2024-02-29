package com.example.contactsapp.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity(tableName = "contacts")
public class Contacts implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "person_id")
    @NonNull
    private int person_id;
    @ColumnInfo(name = "person_name")
    @NonNull
    private String person_name;
    @ColumnInfo(name = "person_phone")
    @NonNull
    private String person_phone;

    public Contacts() {
    }

    public Contacts(int person_id, @NonNull String person_name, @NonNull String person_phone) {
        this.person_id = person_id;
        this.person_name = person_name;
        this.person_phone = person_phone;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    @NonNull
    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(@NonNull String person_name) {
        this.person_name = person_name;
    }

    @NonNull
    public String getPerson_phone() {
        return person_phone;
    }

    public void setPerson_phone(@NonNull String person_phone) {
        this.person_phone = person_phone;
    }
}
