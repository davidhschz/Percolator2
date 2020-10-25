package com.example.percolator2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText valor1, valor2;
    TextView salida;
    Button suma, resta, multiplicacion, division, c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor1 = findViewById(R.id.etvalor1);
        valor2 = findViewById(R.id.etvalor2);
        salida = findViewById(R.id.tvsalida);
        suma = findViewById(R.id.btnsuma);
        resta = findViewById(R.id.btnresta);
        multiplicacion = findViewById(R.id.btnmultiplicacion);
        division = findViewById(R.id.btndivision);
        c = findViewById(R.id.btnc);

        suma.setOnClickListener(this);
        resta.setOnClickListener(this);
        multiplicacion.setOnClickListener(this);
        division.setOnClickListener(this);
        c.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (!valor1.getText().toString().isEmpty() && !valor2.getText().toString().isEmpty()) {
            double num1 = Double.parseDouble(valor1.getText().toString());
            double num2 = Double.parseDouble(valor2.getText().toString());
            double resultado = 0;
            switch (v.getId()){
                case R.id.btnsuma:
                    resultado = num1 + num2;
                    break;
                case R.id.btnresta:
                    resultado = num1 - num2;
                    break;
                case R.id.btnmultiplicacion:
                    resultado = num1 * num2;
                    break;
                case R.id.btndivision:
                    resultado = num1 / num2;
                    break;
            }
            DecimalFormat nro = new DecimalFormat("###,###,###,###,##");
            salida.setText(nro.format(resultado));
        }
        else{
            Toast.makeText(getApplicationContext(), "Ingrese valores", Toast.LENGTH_SHORT).show();
        }

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor1.setText("");
                valor2.setText("");
                salida.setText("");
                valor1.requestFocus();
            }
        });
    }
}