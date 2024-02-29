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
import com.example.contactsapp.UI.ViewModel.RegisterViewModel;
import com.example.contactsapp.databinding.FragmentRegisterPageBinding;
import com.google.android.material.snackbar.Snackbar;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class RegisterPage extends Fragment {
    private FragmentRegisterPageBinding  binding;
    private RegisterViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegisterPageBinding.inflate(inflater,container,false);
        binding.toolbarregister.setTitle("Add New Contact");
        binding.buttonsave.setOnClickListener(v -> {
            String person_name = binding.edittxtpersonname.getText().toString();
            String person_phone = binding.edittxtpersonphone.getText().toString();

            viewModel.save(person_name,person_phone);
            Navigation.findNavController(v).navigate(R.id.saved);
            Snackbar.make(v,"Saved",Snackbar.LENGTH_SHORT).show();
        });
        return binding.getRoot();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(RegisterViewModel.class);
    }
}