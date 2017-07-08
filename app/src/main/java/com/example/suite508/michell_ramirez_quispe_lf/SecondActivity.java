package com.example.suite508.michell_ramirez_quispe_lf;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by suite508 on 08/07/2017.
 */

public class SecondActivity extends AppCompatActivity {

    private EditText etNombre, etApellido, etDocumento, etTelefono, etEdad;
    private Button btActualizar;

    private final View.OnClickListener btActualizarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();

            String name = etNombre.getText().toString();
            String ape = etApellido.getText().toString();
            String documento = etDocumento.getText().toString();
            String fono = etTelefono.getText().toString();
            String edad = etEdad.getText().toString();

            if (TextUtils.isEmpty(name)) {
                Toast.makeText(SecondActivity.this, "El nombre esta vacio", Toast.LENGTH_LONG).show();
                return;
            }

            else {
                intent.putExtra("nombre", etNombre.getText().toString());
            }

            if (TextUtils.isEmpty(ape)) {
                Toast.makeText(SecondActivity.this, "El apellido esta vacio", Toast.LENGTH_LONG).show();
                return;
            }

            else if(TextUtils.isDigitsOnly(ape)) {
                Toast.makeText(SecondActivity.this, "El apellido solo permite letras", Toast.LENGTH_LONG).show();
                return;
            }

            else {
                intent.putExtra("apellido", etApellido.getText().toString());
            }

            if (TextUtils.isEmpty(edad)) {
                Toast.makeText(SecondActivity.this, "La edad esta vacia", Toast.LENGTH_LONG).show();
                return;
            }
            else {
                intent.putExtra("edad", etEdad.getText().toString());
            }


            if (TextUtils.isEmpty(documento)) {
                Toast.makeText(SecondActivity.this, "El documento esta vacio", Toast.LENGTH_LONG).show();
                return;
            }

            else {
                intent.putExtra("documento", etDocumento.getText().toString());
            }

            if (TextUtils.isEmpty(fono)) {
                Toast.makeText(SecondActivity.this, "El telefono esta vacio", Toast.LENGTH_LONG).show();
                return;
            }

            else {
                intent.putExtra("telefono", etTelefono.getText().toString());
            }




            setResult(RESULT_OK,intent);
            finish();
        }

    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etApellido = (EditText) findViewById(R.id.etApellido);
        etDocumento = (EditText) findViewById(R.id.etDocumento);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etEdad = (EditText) findViewById(R.id.etEdad);

        btActualizar = (Button) findViewById(R.id.btActualizar);

        Intent intent= getIntent();

        String nombre = intent.getStringExtra("nombre");
        String apellido = intent.getStringExtra("apellido");
        String dni = intent.getStringExtra("documento");
        String fono = intent.getStringExtra("telefono");
        String edad = intent.getStringExtra("edad");

        etNombre.setText(nombre);
        etApellido.setText(apellido);
        etDocumento.setText(dni);
        etTelefono.setText(fono);
        etEdad.setText(edad);

        if(nombre == null || nombre.equals("")) {
            btActualizar.setText("REGISTRAR");
        }

        btActualizar.setOnClickListener(btActualizarOnClickListener);
    }
}
