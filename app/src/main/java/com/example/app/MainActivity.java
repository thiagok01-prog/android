package com.example.app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
        Button b= findViewById(R.id.button);
        TextView tv =findViewById(R.id.textView);

        EditText edmin=findViewById(R.id.edmin);
        EditText edmax=findViewById(R.id.edmax);

        tv.setText("0");

        b.setOnClickListener(view -> {
            int min=Integer.parseInt( edmin.getText().toString());
            int max=Integer.parseInt( edmax.getText().toString());
        });

        b.setOnClickListener(view -> {
            Random random=new Random();
            int valor=random.nextInt();
            tv.setText(Integer.toString(valor));
        });


    }
}