package com.wposs.pruebalogica1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnAdd, btnAdd2, btnComprobar;
    TextView tvResultado, tvResultado2, tvResultado3;
    EditText etTexto, etNum, etTexto2;
    String s = "";
    String s2 = "";
    List<String> arrayList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
        btnAdd.setOnClickListener(view -> OrdenarFrases());
        btnAdd2.setOnClickListener(view -> ordenarnumero());
        btnComprobar.setOnClickListener(view -> comprobar());
    }

    private void comprobar() {
        if (etTexto2.getText().toString().isEmpty()) {
            etTexto2.setError("Debes ingresar un valor");
            return;
        }
        String cadena = etTexto2.getText().toString();
        cadena = cadena.toLowerCase().replace(" ", "");
        String invertida = new StringBuilder(cadena).reverse().toString();
        if (!invertida.equals(cadena)) {
            tvResultado3.setText("No es Palidronomo");
            return;
        }
        tvResultado3.setText("Si es Palidronomo");

    }

    private void ordenarnumero() {
        if (etNum.getText().toString().isEmpty()) {
            etNum.setError("Debes ingresar un valor");
            return;
        }

        s = etNum.getText().toString();

        if (!tvResultado2.getText().toString().isEmpty()) {

            s2 = tvResultado2.getText() + " " + s;

            String[] parts = s2.split(" ");

            for (int i = 0; i < parts.length - 1; i++) {
                for (int j = 0; j < parts.length - i - 1; j++) {
                    if (Integer.parseInt(parts[j]) < Integer.parseInt(parts[j + 1])) {
                        int tmp = Integer.parseInt(parts[j + 1]);
                        parts[j + 1] = parts[j];
                        parts[j] = String.valueOf(tmp);
                    }
                }
            }
            String cadenaTexto = "";
            for (int i = 0; i < parts.length; i++) {
                if (!cadenaTexto.equals("")) {
                    cadenaTexto = cadenaTexto + " " + parts[i];

                } else
                    cadenaTexto = parts[i];

            }
            tvResultado2.setText(cadenaTexto);
            return;
        }
        tvResultado2.setText(s);
    }


    private void OrdenarFrases() {
        if (etTexto.getText().toString().isEmpty()) {
            etNum.setError("Debes ingresar un valor");
            return;
        }
        if (etTexto.getText().toString().contains("end-of-file")) {
            btnAdd.setEnabled(false);
        }
        arrayList.add(etTexto.getText().toString());
        int agregar = 1;
        String cadenaTexto = "";
        for (int i = 0; i < arrayList.size(); i++) {
            cadenaTexto = (cadenaTexto + " " + Integer.toString(agregar) + " " + arrayList.get(i));
            agregar++;
        }
        tvResultado.setText(cadenaTexto);

    }


    private void inicializar() {
        etTexto = findViewById(R.id.etTexto);
        btnAdd = (Button) findViewById(R.id.btn_add);
        tvResultado = (TextView) findViewById(R.id.tv_result);
        etNum = findViewById(R.id.etNum);
        btnAdd2 = (Button) findViewById(R.id.btn_add2);
        tvResultado2 = (TextView) findViewById(R.id.tv_result2);
        etTexto2 = findViewById(R.id.et_text2);
        btnComprobar = (Button) findViewById(R.id.btn_comprobar);
        tvResultado3 = (TextView) findViewById(R.id.tv_result3);

    }
}