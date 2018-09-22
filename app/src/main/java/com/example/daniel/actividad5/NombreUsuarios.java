package com.example.daniel.actividad5;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NombreUsuarios
        extends RecyclerView.Adapter<NombreUsuarios.ViewHolderusuarios>
        implements View.OnClickListener{

    private ArrayList<Usuario> listausuarios;
    private View.OnClickListener listener;

    public NombreUsuarios(ArrayList<Usuario> listausuarios) {
        this.listausuarios = listausuarios;
    }

    @Override
    public ViewHolderusuarios onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout=0;
        if (Utilidades.visualizacion==Utilidades.LIST){
            layout=R.layout.item;
        }else {
            layout=R.layout.item2;
        }

        View view= LayoutInflater.from(parent.getContext()).inflate(layout,null,false);

        view.setOnClickListener(this);

        return new ViewHolderusuarios(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderusuarios holder, int position) {
        holder.etiNombre.setText(listausuarios.get(position).getNombre());
        holder.etiEdad.setText(listausuarios.get(position).getEdad());


        if (Utilidades.visualizacion==Utilidades.LIST){
            holder.etiApellido.setText(listausuarios.get(position).getApellido());

        }

        holder.foto.setImageResource(listausuarios.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return listausuarios.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolderusuarios extends RecyclerView.ViewHolder {

        TextView etiNombre, etiApellido, etiEdad;
        ImageView foto;

        public ViewHolderusuarios(View itemView) {
            super(itemView);
            etiNombre= (TextView) itemView.findViewById(R.id.idNombre);
            if (Utilidades.visualizacion==Utilidades.LIST){
                etiApellido= (TextView) itemView.findViewById(R.id.idApellido);
                etiEdad= (TextView)itemView.findViewById(R.id.idEdad);
            }
            foto= (ImageView) itemView.findViewById(R.id.idImagen);
        }
    }
}