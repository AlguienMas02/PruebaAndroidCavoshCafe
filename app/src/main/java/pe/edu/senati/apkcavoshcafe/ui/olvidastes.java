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
import pe.edu.senati.apkcavoshcafe.databinding.FragmentLoginBinding;
import pe.edu.senati.apkcavoshcafe.databinding.FragmentOlvidasteBinding;

public class olvidastes extends Fragment {
    FragmentOlvidasteBinding binding;
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
        binding = FragmentOlvidasteBinding.inflate(inflater, container, false);
        return view = binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getContext();
        navController = Navigation.findNavController( view );

        binding.btnEnviar.setOnClickListener( v -> btnEnviar() );
    }
    private void btnEnviar(){
        //chapa ciorreo
        String sCorreo = binding.tilCorreo.getEditText().getText().toString();
        //validación
        //api -> generar el codigo, guardar código, enviar correo
        Bundle bundle = new Bundle(); // traspaso
        bundle.putString("validar", "password");
        bundle.putString("correo", sCorreo);
        navController.navigate(R.id.navigation_verificar, bundle); // envia
    }
}