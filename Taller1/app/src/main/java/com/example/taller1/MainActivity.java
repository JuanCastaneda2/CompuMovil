package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botonFibonacci = (Button) findViewById(R.id.botonFibonacci);
        botonFibonacci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText num = (EditText) findViewById(R.id.numero);
                if (num.getText().toString().equals("")){
                    Toast.makeText(view.getContext(), "Ingrese un numero", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(view.getContext(), fibonacci.class);
                    intent.putExtra("num", num.getText().toString());
                    startActivity(intent);
                }
            }
        });

        List<Integer> spinnerArray =  new ArrayList<Integer>();
        for(int i = 1; i<16 ; i++ ){
            spinnerArray.add(i);
        }

        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.spinnerFactorial);
        sItems.setAdapter(adapter);

        Button botonFactorial = (Button) findViewById(R.id.factorial);
        botonFactorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner spin = (Spinner) findViewById(R.id.spinnerFactorial);
                Intent intent = new Intent(view.getContext(), Factorial.class);
                String value =  spin.getSelectedItem().toString();
                intent.putExtra("factor", value);
                startActivity(intent);
            }
        });

    }
}