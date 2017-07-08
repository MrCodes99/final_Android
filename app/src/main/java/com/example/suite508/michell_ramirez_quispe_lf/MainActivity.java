package com.example.suite508.michell_ramirez_quispe_lf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private Button btMain;
    private ListView lvMain;
    private LVMainAdapter mLVMainAdapter;
    private int REQUEST_CODE = 20;
    private int UPDATE_CODE = 30;
    private int posi = -1;

    private final View.OnClickListener btMainOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);

            startActivityForResult(intent, REQUEST_CODE);
        }
    };

    private final AdapterView.OnItemClickListener lvMainOnItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

            Persona persona = mLVMainAdapter.getItem(position);

            posi = position;

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);

            intent.putExtra("nombre", persona.getNombre().toString());
            intent.putExtra("apellido", persona.getApellido().toString());
            intent.putExtra("documento", persona.getDocumento().toString());
            intent.putExtra("telefono", persona.getTelefono().toString());
            intent.putExtra("edad", persona.getEdad());

            startActivityForResult(intent, UPDATE_CODE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMain = (ListView) findViewById(R.id.lvMain);
        btMain = (Button) findViewById(R.id.btMain);

        btMain.setOnClickListener(btMainOnClickListener);
        lvMain.setOnItemClickListener(lvMainOnItemClickListener);

        mLVMainAdapter = new LVMainAdapter(MainActivity.this);
        lvMain.setAdapter(mLVMainAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK) {
            if(requestCode == REQUEST_CODE) {
                Persona persona = new Persona();
                persona.setId(java.util.UUID.randomUUID().toString());
                persona.setNombre(data.getStringExtra("nombre"));
                persona.setApellido(data.getStringExtra("apellido"));
                persona.setDocumento(data.getStringExtra("documento"));
                persona.setTelefono(data.getStringExtra("telefono"));
                persona.setEdad(data.getStringExtra("edad"));

                mLVMainAdapter.add(persona);
                mLVMainAdapter.notifyDataSetChanged();
            }
            else if(requestCode==UPDATE_CODE){

                Persona persona = mLVMainAdapter.getItem(posi);

                mLVMainAdapter.remove(persona);

                persona.setNombre(data.getStringExtra("nombre"));
                persona.setApellido(data.getStringExtra("apellido"));
                persona.setDocumento(data.getStringExtra("documento"));
                persona.setTelefono(data.getStringExtra("telefono"));
                persona.setEdad(data.getStringExtra("edad"));

                mLVMainAdapter.insert(persona,posi);
                mLVMainAdapter.notifyDataSetChanged();
            }
        }
    }
}
