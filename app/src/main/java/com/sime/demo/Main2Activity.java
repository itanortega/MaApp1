package com.sime.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        TextView txt_programa = (TextView) findViewById(R.id.programa);
        TextView txt_asignatura = (TextView) findViewById(R.id.asignatura);
        TextView txt_docente = (TextView) findViewById(R.id.docente);
        TextView txt_alumno = (TextView) findViewById(R.id.alumno);
        TextView txt_codigo = (TextView) findViewById(R.id.codigo);

        txt_programa.setText(intent.getStringExtra("programa"));
        txt_asignatura.setText(intent.getStringExtra("asignatura"));
        txt_docente.setText(intent.getStringExtra("docente"));
        txt_alumno.setText(intent.getStringExtra("alumno"));
        txt_codigo.setText(intent.getStringExtra("codigo"));

    }
}
