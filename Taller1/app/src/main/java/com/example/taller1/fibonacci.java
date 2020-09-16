package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class fibonacci extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci);

        String num = getIntent().getStringExtra("num");
        int numero = Integer.parseInt(num);
        double [] dictionary = new double[numero+1];
        dictionary[1] = 1;

        LinearLayout linearLayout = this.findViewById(R.id.numeros);
        Button fib = (Button) findViewById(R.id.fibonacci);

        mostrarSerie(numero,linearLayout,dictionary);

        fib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebView web = new WebView(view.getContext());
                setContentView(web);
                web.setWebViewClient( new WebViewClient());
                web.loadUrl("https://es.wikipedia.org/wiki/Leonardo_de_Pisa");
            }
        });

    }

    double sucesion_fibonacci(int n, double[]dictionary)
    {

        if (n < 2)
        {
            return n;
        }
        else
        {
            double f = dictionary[n];
            if (f == 0) {
                f = sucesion_fibonacci(n-1,dictionary) + sucesion_fibonacci(n-2,dictionary);
                dictionary[n] = f;
            }
            return f;
        }
    }

    void mostrarSerie(int numero, LinearLayout linear, double[]dictionary){
        sucesion_fibonacci(numero,dictionary);
        for (int i = 0; i < numero; i++) {
            TextView num_serie = new TextView(this);
            num_serie.setText(Double.toString(dictionary[i]));
            linear.addView(num_serie);
        }
    }
}