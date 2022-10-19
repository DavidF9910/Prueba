package com.wposs.pruebalogica1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnAdd, btnAdd2;
    TextView tvResultado, tvResultado2;
    EditText etTexto, etNum;
    String s="";
    List<String> arrayList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
        btnAdd.setOnClickListener(view -> agregar());
      //  btnAdd2.setOnClickListener(view -> agregar2());
    }
/*
    private void agregar2() {
      s = tvResultado2.getText().toString();
      String s2 = (String) tvResultado2.getText();
      String[] parts = s2.split(" ");
     for(int i = 0; i < parts.length; i++) {
         int j=Integer.parseInt(parts[i]);
         if (j>Integer.parseInt(s)){
             parts[i].replace(s);
         }
     }
    }
*/
    private void agregar() {
        if (etTexto.getText().toString().contains("end-of-file")) {
            btnAdd.setEnabled(false);
        }
        arrayList.add(etTexto.getText().toString());
        //El iterador se encarga de recorrer el arreglo
        Iterator<String> iterator = arrayList.iterator();
        int i = 1;
        while (iterator.hasNext()) {
            System.out.println(i + " " + iterator.next());
            i++;
        }
    }


    private void inicializar() {
        etTexto = findViewById(R.id.etTexto);
        btnAdd = (Button) findViewById(R.id.btn_add);
        tvResultado = (TextView) findViewById(R.id.tv_result);
        etNum = findViewById(R.id.etNum);
        btnAdd2 = (Button) findViewById(R.id.btn_add2);
        tvResultado2 = (TextView) findViewById(R.id.tv_result2);

    }
}