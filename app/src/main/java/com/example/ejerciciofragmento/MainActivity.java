package com.example.ejerciciofragmento;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ejerciciofragmento.fragmentos.FragmentoAbajo;
import com.example.ejerciciofragmento.fragmentos.FragmentoArriba;
import com.example.ejerciciofragmento.fragmentos.FragmentoMedio;
import com.example.ejerciciofragmento.interfaces.IControlFragmentos;

public class MainActivity extends AppCompatActivity implements IControlFragmentos {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //CARGAMOS FRAGMENTOS ARRIBA
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.ContenedorArriba, new FragmentoArriba()).commit();
        //CARGAMOS FRAGMENTO MEDIO
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.ContenedorMedio, new FragmentoMedio()).commit();
        //CARGAMOS FRAGMENTO ABAJO
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.ContenedorAbajo, new FragmentoAbajo()).commit();
    }

    @Override
    public void pasarTexto(String texto) {
        Bundle bundle = new Bundle();
        bundle.putString("nombre", texto);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.ContenedorMedio, new FragmentoMedio(bundle)).commit();

    }

    @Override
    public void pasarTexto(String nombre, String apellido, String fecha) {
        Bundle bundle = new Bundle();
        bundle.putString("nombre", nombre);
        bundle.putString("apellido", apellido);
        bundle.putString("fecha", fecha);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.ContenedorAbajo, new FragmentoAbajo.newInstance()).commit();
    }


}