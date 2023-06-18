package com.example.finalapp.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalapp.MyAdapter;
import com.example.finalapp.R;
import com.example.finalapp.databinding.FragmentGalleryBinding;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private RecyclerView recyclerView, recyclerView2;
    private MyAdapter adapter, adapter2;
    private ArrayList<String> titulo1, descrp1, titulo2, descrp2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.recyclerMenu);

        titulo1 = new ArrayList<>();
        titulo1.add("Carne en su jugo");
        titulo1.add("Birria");
        titulo1.add("Arrachera");

        descrp1 = new ArrayList<>();
        descrp1.add("  $250");
        descrp1.add("  $300");
        descrp1.add("  $550");

        recyclerView2 = root.findViewById(R.id.RecyclerMenu2);

        titulo2 = new ArrayList<>();
        titulo2.add("Sushi");
        titulo2.add("Caldo pescado");
        titulo2.add("Camarones a la diabla");

        descrp2 = new ArrayList<>();
        descrp2.add("  $150");
        descrp2.add("  $300");
        descrp2.add("  $250");

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView2.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        adapter = new MyAdapter(titulo1, descrp1,this.getContext());
        recyclerView.setAdapter(adapter);

        adapter2 = new MyAdapter(titulo2, descrp2, this.getContext());
        recyclerView2.setAdapter(adapter2);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}