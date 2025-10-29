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
import pe.edu.senati.apkcavoshcafe.databinding.FragmentValidarBinding;

public class Validar extends Fragment {
    FragmentValidarBinding binding;
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
        binding = FragmentValidarBinding.inflate(inflater,container,false);
        return view = binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getContext();
        navController = Navigation.findNavController( view );

        binding.btnValidarCodigo.setOnClickListener(v -> btnValidar_Click() );
    }

    private void btnValidar_Click() {
        String sValidar = getArguments().getString("validar");
        String sCorreo = getArguments().getString("correo");
        String sCodigo = binding.tilCodigo.getEditText().getText().toString().trim();

        // api -> validar el código para el correo y "validar"

        if ( sValidar.equals("passwordd") ) {
            Bundle bundle = new Bundle();
            bundle.putString("correo", sCorreo);
            navController.navigate( R.id.navigation_password, bundle );
        }
        else if ( sValidar.equals("registrar") ) {
            // registrar usuario en bd local
            navController.navigate( R.id.navigation_inicio  );
        }
    }

}