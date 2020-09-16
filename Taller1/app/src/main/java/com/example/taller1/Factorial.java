package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Factorial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial);

        int num = Integer.parseInt(getIntent().getStringExtra("factor"));
        TextView op = this.findViewById(R.id.operacion);

        String resultado = "Operacion: " + operacion(num) + "\nResultado: " + Integer.toString(factorial(num));
        op.setText(resultado);
    }

    public int factorial (int numero) {
        if (numero==0)
            return 1;
        else
            return (int) (numero * factorial(numero-1));
    }

    public String operacion(int numero){
        String resultado = "";
        if (numero==0)
            return "0";
        else{
            for (int i = 1 ; i< numero ; i++){
                resultado = resultado +  i + " * ";
            }
            resultado = resultado + numero;
        }
        return resultado;
    }
}