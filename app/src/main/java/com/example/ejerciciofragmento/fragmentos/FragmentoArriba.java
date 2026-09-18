package com.example.ejerciciofragmento.fragmentos;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.ejerciciofragmento.MainActivity;
import com.example.ejerciciofragmento.R;
import com.example.ejerciciofragmento.interfaces.IControlFragmentos;


public class FragmentoArriba extends Fragment {

    private IControlFragmentos activity;

    public FragmentoArriba() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragmento_arriba, container, false);
    }

    @Override
    public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        Button btnCargar = view.findViewById(R.id.btnCrear);
        btnCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etNombre = view.findViewById(R.id.etNombre);
                activity.pasarTexto(etNombre.getText().toString());
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        MainActivity activity = (MainActivity) context;
        this.activity = (IControlFragmentos) context;
    }

}