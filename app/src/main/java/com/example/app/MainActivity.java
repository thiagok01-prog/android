package com.example.app;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    String nomes[] = new String[]{"nome1", "nome2", "nome3", "nome4", "nome5", "nome6", "nome7"};
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
        ListView listanomes = findViewById(R.id.ListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.iteml_ista, R.id.textView, nomes);
        listanomes.setAdapter(adapter);
        listanomes.setOnItemClickListener((adapterView, view, i, l) -> {
            Toast.makeText(getApplicationContext(), nomes[i], Toast.LENGTH_LONG).show();
        });

    }
}