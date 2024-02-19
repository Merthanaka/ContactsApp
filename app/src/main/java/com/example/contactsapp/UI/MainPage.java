        package com.example.contactsapp.UI;

        import android.os.Bundle;

        import androidx.annotation.Nullable;
        import androidx.lifecycle.ViewModelProvider;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.fragment.app.Fragment;
        import androidx.navigation.Navigation;

        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.SearchView;

        import com.example.contactsapp.R;
        import com.example.contactsapp.UI.ViewModel.MainScreenViewModel;
        import com.example.contactsapp.UI.adapter.ContactsAdapter;
        import com.example.contactsapp.data.entity.Contacts;
        import com.example.contactsapp.databinding.FragmentMainPageBinding;

        import java.util.ArrayList;

        public class MainPage extends Fragment {
            private FragmentMainPageBinding binding;
            private MainScreenViewModel viewModel;
            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                binding = FragmentMainPageBinding.inflate(inflater,container,false);
                binding.toolbarmainp.setTitle("Contacts");
                binding.rv.setLayoutManager(new LinearLayoutManager(requireContext()));
                viewModel.contactList.observe(getViewLifecycleOwner(),contacts -> {
                    ContactsAdapter contactsAdapter = new ContactsAdapter(requireContext(),contacts,viewModel);
                    binding.rv.setAdapter(contactsAdapter);
                });

                binding.fab.setOnClickListener(v -> {
                    Navigation.findNavController(v).navigate(R.id.maintoregister);
                });
                binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        viewModel.search(query);
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        viewModel.search(newText);
                        return false;
                    }
                });
                return binding.getRoot();
            }

            @Override
            public void onCreate(@Nullable Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                viewModel = new ViewModelProvider(this).get(MainScreenViewModel.class);
            }

            @Override
            public void onResume() {
                super.onResume();
                viewModel.loadContacts();
            }
        }