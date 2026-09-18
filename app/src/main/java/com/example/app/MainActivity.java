package com.example.app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int posicao=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Integer[] imagens = new Integer[]{
                R.drawable.cachorro,
                R.drawable.gardem,
                R.drawable.happy,
                R.drawable.patinho,
                R.drawable.porquinho
        };
        Button botaoVoltar, botaoAvancar;
        botaoVoltar=findViewById(R.id.btnanterior);
        botaoAvancar=findViewById(R.id.btnproximo);
        ImageView imageView=findViewById(R.id.imageView);

        botaoAvancar.setOnClickListener(v -> {
            posicao++;
            imageView.setImageResource(imagens[posicao]);
        });

    }
}