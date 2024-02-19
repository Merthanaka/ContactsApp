package com.example.contactsapp.UI.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactsapp.UI.MainPageDirections;
import com.example.contactsapp.UI.ViewModel.MainScreenViewModel;
import com.example.contactsapp.UI.adapter.ContactsAdapter;
import com.example.contactsapp.data.entity.Contacts;
import com.example.contactsapp.databinding.CartDesignBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.CardDesignHolder>{
    private Context mContext;
    private List<Contacts> contactsList;
    private MainScreenViewModel viewModel;

    public ContactsAdapter(Context mContext, List<Contacts> contactsList, MainScreenViewModel viewModel) {
        this.mContext = mContext;
        this.contactsList = contactsList;
        this.viewModel = viewModel;
    }



    public class CardDesignHolder extends RecyclerView.ViewHolder{
        private CartDesignBinding design;

        public CardDesignHolder(CartDesignBinding design) {
            super(design.getRoot());
            this.design = design;
        }
    }
    @NonNull
    @Override
    public CardDesignHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CartDesignBinding binding = CartDesignBinding.inflate(LayoutInflater.from(mContext),parent,false);
        return new CardDesignHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardDesignHolder holder, int position) {
        Contacts contacts = contactsList.get(position);
        CartDesignBinding t = holder.design;
        t.contactName.setText(contacts.getPerson_name());
        t.contactnumber.setText(contacts.getPerson_phone());
        t.cardViewone.setOnClickListener(v -> {
            MainPageDirections.Maintodetails pass = MainPageDirections.maintodetails(contacts);
            Navigation.findNavController(v).navigate(pass);
        });
        t.imgdel.setOnClickListener(v -> {
            Snackbar.make(v,"Delete "+contacts.getPerson_name()+"?",Snackbar.LENGTH_SHORT)
                    .setAction("Yes",v1 -> {
                        viewModel.delete(contacts.getPerson_id());
                    }).show();
        });
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

}
