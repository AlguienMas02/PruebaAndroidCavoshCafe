package pe.edu.senati.apkcavoshcafe.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.edu.senati.apkcavoshcafe.R;
import pe.edu.senati.apkcavoshcafe.databinding.FragmentVerificarBinding;

public class Validar extends Fragment {

    FragmentVerificarBinding binding;
    Context context;
    View view;
    NavController navController;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentVerificarBinding.inflate(inflater, container, false);
        return view = binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getContext();
        navController = Navigation.findNavController(view);

        binding.btnVerificar.setOnClickListener(v -> btnVerificar_Click());
    }

    private void btnVerificar_Click() {
        String sValidar =getArguments().getString("validar");
        String sCodigo = getArguments().getString("correo");
        String sCorreo = binding.tilCodigo.getEditText().getText().toString().trim();

        if (sValidar.equals("password"))
            navController.navigate(R.id.navigation_password);
        else if(sValidar.equals("registrar")){

        }
    }

}