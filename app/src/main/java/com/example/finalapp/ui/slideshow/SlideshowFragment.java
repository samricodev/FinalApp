package com.example.finalapp.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.finalapp.Pedido;
import com.example.finalapp.R;
import com.example.finalapp.databinding.FragmentSlideshowBinding;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class SlideshowFragment extends Fragment {

    private TextView info_pedido;
    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        info_pedido = (TextView) root.findViewById(R.id.txtInfoPedido);

        abrirArchivo();

        return root;
    }

    private void abrirArchivo(){
        String archivos [] = getActivity().fileList();
        if(existeArchivo(archivos, "pedidos.txt")){
            try{
                InputStreamReader archivoInterno = new InputStreamReader(getActivity().openFileInput("pedidos.txt"));
                BufferedReader leerArchivo = new BufferedReader(archivoInterno);
                String linea = leerArchivo.readLine();
                String textoLeido = "";
                while( linea != null){
                    textoLeido += linea + '\n';
                    linea = leerArchivo.readLine();
                }
                leerArchivo.close();
                archivoInterno.close();
                info_pedido.setText(textoLeido);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                Toast.makeText(this.getContext(), "Error al leer el archivo.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this.getContext(), "El archivo no existe.", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean existeArchivo(String[] archivos, String file) {
        for (int i = 0; i < archivos.length; i++)
            if(file.equals(archivos[i]))
                return true;
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}