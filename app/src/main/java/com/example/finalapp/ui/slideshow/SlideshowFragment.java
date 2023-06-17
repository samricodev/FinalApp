package com.example.finalapp.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.finalapp.Pedido;
import com.example.finalapp.R;
import com.example.finalapp.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

    private TextView info_pedido;
    private Pedido pedido;

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        pedido = (Pedido) getActivity().getIntent().getSerializableExtra("pedido");
        info_pedido = (TextView) root.findViewById(R.id.txtInfoPedido);

        String pedidoText = "Id: " + pedido.getId() +
                "\nNombre: " + pedido.getNombre() +
                "\nDomicilio: " + pedido.getDomicilio() +
                "\nTelefono: " + pedido.getTelefono() +
                "\nTotal: " + pedido.getTotal() +
                "\nMetodo de pago: " + pedido.getMetodo_pago();

        info_pedido.setText(pedidoText);

      /*  Pedido pedido = getArguments().getParcelable("pedido");
*/
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}