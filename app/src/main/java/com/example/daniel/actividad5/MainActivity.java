package com.example.daniel.actividad5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Usuario> listausuarios;
    RecyclerView recyclerusuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        construirRecycler();

    }

    private void llenarusuarios() {
        listausuarios.add(new Usuario("Diego Daniel","Martinez Cortez", "21", R.drawable.icono));
        listausuarios.add(new Usuario("Jose Isaac","Zermeño Sanchez", "22", R.drawable.icono));
        listausuarios.add(new Usuario("Jesus Alejandro","Leal de la Garza", "21", R.drawable.icono));
    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnList: Utilidades.visualizacion=Utilidades.LIST;
                break;
            //case R.id.btnGrid: Utilidades.visualizacion=Utilidades.GRID;
              //  break;
        }
        construirRecycler();
    }

    private void construirRecycler() {
        listausuarios =new ArrayList<>();
        recyclerusuarios = (RecyclerView) findViewById(R.id.RecyclerId);

        if (Utilidades.visualizacion==Utilidades.LIST){
            recyclerusuarios.setLayoutManager(new LinearLayoutManager(this));
        }else {
            recyclerusuarios.setLayoutManager(new GridLayoutManager(this,3));
        }

        llenarusuarios();

        NombreUsuarios adapter=new NombreUsuarios(listausuarios);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Selección: "+ listausuarios.get
                                (recyclerusuarios.getChildAdapterPosition(view))
                                .getNombre(),Toast.LENGTH_SHORT).show();
            }
        });

        recyclerusuarios.setAdapter(adapter);
    }
}
