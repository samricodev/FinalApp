package com.example.finalapp.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalapp.MyAdapter;
import com.example.finalapp.R;
import com.example.finalapp.databinding.FragmentGalleryBinding;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private ArrayList<String> dataList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.recyclerMenu);

        dataList = new ArrayList<>();
        dataList.add("Carne en su jugo");
        dataList.add("Birria");
        dataList.add("Camarones a la diabla");



        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        //recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        adapter = new MyAdapter(dataList,this.getContext());
        recyclerView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}