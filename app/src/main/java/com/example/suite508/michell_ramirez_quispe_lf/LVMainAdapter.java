package com.example.suite508.michell_ramirez_quispe_lf;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by suite508 on 08/07/2017.
 */

public class LVMainAdapter extends ArrayAdapter<Persona> {
    public LVMainAdapter(Context context) {
        super(context, 0, new ArrayList<Persona>());
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.main_item, parent, false);

        TextView tvFullName, tvDocumento, tvTelefono, tvEdad;

        tvFullName = (TextView) convertView.findViewById(R.id.tvFullName);
        tvDocumento = (TextView) convertView.findViewById(R.id.tvDocumento);
        tvTelefono = (TextView) convertView.findViewById(R.id.tvTelefono);
        tvEdad = (TextView) convertView.findViewById(R.id.tvEdad);

        Persona persona = getItem(position);

        tvFullName.setText(persona.getNombre() + " " + persona.getApellido());
        tvDocumento.setText(persona.getDocumento());
        tvTelefono.setText(persona.getTelefono());
        tvEdad.setText(persona.getEdad());

        return convertView;
    }
}
