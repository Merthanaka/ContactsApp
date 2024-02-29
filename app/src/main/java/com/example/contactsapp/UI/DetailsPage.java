package com.example.contactsapp.UI;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.contactsapp.R;
import com.example.contactsapp.UI.ViewModel.ContactDetailsViewModel;
import com.example.contactsapp.data.entity.Contacts;
import com.example.contactsapp.databinding.FragmentDetailsPageBinding;
import com.example.contactsapp.databinding.FragmentRegisterPageBinding;
import com.google.android.material.snackbar.Snackbar;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DetailsPage extends Fragment {
    private FragmentDetailsPageBinding binding;
    private ContactDetailsViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailsPageBinding.inflate(inflater,container,false);
        binding.toolbardetailsp.setTitle("Contact Detail");
        DetailsPageArgs bundle = DetailsPageArgs.fromBundle(getArguments());
        Contacts comingcontacts = bundle.getContact();
        binding.edittxtpersonname.setText(comingcontacts.getPerson_name());
        binding.edittxtpersonphone.setText(comingcontacts.getPerson_phone());
        binding.buttonupdate.setOnClickListener(v -> {
            String person_name = binding.edittxtpersonname.getText().toString();
            String person_phone = binding.edittxtpersonphone.getText().toString();
            viewModel.update(comingcontacts.getPerson_id(),person_name,person_phone);
            Navigation.findNavController(v).navigate(R.id.updated);
            Snackbar.make(v,"Updated",Snackbar.LENGTH_SHORT).show();

        });

        return binding.getRoot();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(ContactDetailsViewModel.class);
    }
}