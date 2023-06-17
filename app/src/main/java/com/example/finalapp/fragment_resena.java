package com.example.finalapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_resena#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_resena extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText nombre, titulo, fecha, descrip;
    private CheckBox c1, c2, c3, c4, c5;
    private Button btnEnviar;
    public fragment_resena() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_resena.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_resena newInstance(String param1, String param2) {
        fragment_resena fragment = new fragment_resena();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_resena, container, false);

        nombre = view.findViewById(R.id.txtNombre_resena);
        titulo = view.findViewById(R.id.txtTitulo_resena);
        fecha = view.findViewById(R.id.txtFecha_resena);
        descrip = view.findViewById(R.id.txtDescripcion_resena);
        c1 = view.findViewById(R.id.cb1_resena);
        c2 = view.findViewById(R.id.cb2_resena);
        c3 = view.findViewById(R.id.cb3_resena);
        c4 = view.findViewById(R.id.cb4_resena);
        c5 = view.findViewById(R.id.cb5_resena);

        btnEnviar = view.findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(v -> enviarRes(view));

        return view;
    }

    public void enviarRes(View view){
        int starts = 0;

        if(c1.isChecked()){
            starts++;
        }
        if(c2.isChecked()){
            starts++;
        }
        if(c3.isChecked()){
            starts++;
        }
        if(c4.isChecked()){
            starts++;
        }
        if(c5.isChecked()){
            starts++;
        }

        Reseña res = new Reseña(nombre.getText().toString(), titulo.getText().toString(), fecha.getText().toString()
                    , descrip.getText().toString(), starts);

        String response = "Reseña\n" + "Nombre: " + res.getNombre() + " Titulo: " + res.getTitulo()
                + " Fecha: " + res.getFecha() + " Descripcion: " + res.getDescripcion()
                + " Calificacion: " + res.getCalificacion() + " estrellas";

        limpiarResena();

        Toast.makeText(this.getContext(), response, Toast.LENGTH_LONG).show();
    }

    public void limpiarResena(){
        nombre.setText(null);
        titulo.setText(null);
        fecha.setText(null);
        descrip.setText(null);
        c1.setChecked(false);
        c2.setChecked(false);
        c3.setChecked(false);
        c4.setChecked(false);
        c5.setChecked(false);
    }
}