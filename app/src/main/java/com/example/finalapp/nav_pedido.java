package com.example.finalapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.PrimitiveIterator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link nav_pedido#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class nav_pedido extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText id, nombre,domicilio,telefono, total;
    private RadioButton efectivo, tarjeta;
    private Pedido pedido;
    private Button hacer_pedido;

    // TODO: Rename and change types and number of parameters
    public static nav_pedido newInstance(String param1, String param2) {
        nav_pedido fragment = new nav_pedido();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public nav_pedido() {
        // Required empty public constructor
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
        View view = inflater.inflate(R.layout.fragment_nav_pedido, container, false);

        id = (EditText) view.findViewById(R.id.txtIdPedido);
        nombre = (EditText) view.findViewById(R.id.txtNombrePedido);
        domicilio = (EditText) view.findViewById(R.id.txtDomicilioPedido);
        telefono = (EditText) view.findViewById(R.id.txtTelefonoPedido);
        total = (EditText) view.findViewById(R.id.txtTotalPedido);
        efectivo = (RadioButton) view.findViewById(R.id.rbtnEfectivo);
        tarjeta = (RadioButton) view.findViewById(R.id.rbtnTDDTDC);
        hacer_pedido = (Button) view.findViewById(R.id.btnHacerPedido);

        hacer_pedido.setOnClickListener(v -> guardarPedido(view) );

        return view;
    }

    public void guardarPedido(View view){

        Pedido pedido = new Pedido();

        String nombre_p = (nombre.getText().toString());
        String domicilio_p = domicilio.getText().toString();
        String telefono_p = telefono.getText().toString();
        String total_p = total.getText().toString();

        //validacion de campos
        if (nombre_p.isEmpty() || domicilio_p.isEmpty() || telefono_p.isEmpty()
        || total_p.isEmpty() || (!efectivo.isChecked() && !tarjeta.isChecked())){
            Toast.makeText(getActivity(), "CAMPOS INCOMPLETOS", Toast.LENGTH_SHORT).show();
            limpiar();
        }else {
            pedido.setId(Integer.parseInt(id.getText().toString()));
            pedido.setNombre(nombre.getText().toString());
            pedido.setDomicilio(domicilio.getText().toString());
            pedido.setTelefono(Long.parseLong(telefono.getText().toString()));
            pedido.setTotal(Float.parseFloat(total.getText().toString()));
            String pago = "";
            if (efectivo.isChecked()){
                pedido.setMetodo_pago("Efectivo.");
            } else if (tarjeta.isChecked()) {
                pedido.setMetodo_pago("Tarjeta");
            }else {
                Toast.makeText(getActivity(), "No se ha seleccionado el metodo de pago.", Toast.LENGTH_SHORT).show();
            }
            Intent intent = new Intent(getActivity(), ActivityMenu.class);
            intent.putExtra("pedido",pedido);
            Toast.makeText(getActivity(), "Pedido Realizado.", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            getActivity().finish();
        }
    }//guardarPedido

    public void limpiar(){
        nombre.setText("");
        domicilio.setText("");
        id.setText("");
        telefono.setText("");
        total.setText("");
        tarjeta.setChecked(false);
        efectivo.setChecked(false);
    }//limpiar

}//onCreateView

//comentario