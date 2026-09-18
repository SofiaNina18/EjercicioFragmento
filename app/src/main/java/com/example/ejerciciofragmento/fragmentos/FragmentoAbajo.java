package com.example.ejerciciofragmento.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ejerciciofragmento.R;


public class FragmentoAbajo extends Fragment {





    public FragmentoAbajo() {
        // Required empty public constructor
    }

    public static Fragment newIntance(Bundle bundle){
        FragmentoAbajo fragmentoAbajo = new FragmentoAbajo();
        if (bundle != null){
            fragmentoAbajo.setArguments(bundle);
        }
        return fragmentoAbajo;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragmento_abajo, container, false);
    }
}