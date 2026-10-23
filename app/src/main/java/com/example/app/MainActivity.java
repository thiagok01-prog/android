package com.example.app;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database; //declara uma variavel do tipo SQLiteDatabase
    EditText editText;
    Button button;
    ListView listView;
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
        database=openOrCreateDatabase("notinhas", MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS notinhas (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo VARCHAR, conteudo VARCHAR)");
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.edittext);
        button=findViewById(R.id.button);
        listView=findViewById(R.id.listview);
        List.setOnItemClickListener(()->{
            Toast.makeText(getApplicationContext(), "asdf", Toast.LENGTH_LONG).show();
        });

        button.setOnClickListener(v -> {
            String titulo=editText.getText().toString();
            ContentValues values = new ContentValues();
            values.put("titulo", titulo);
            int id=(int)database.insert("notinhas", null, values);
            if (id>0) {
                Toast.makeText(this, "Nota salva com sucesso", Toast.LENGTH_SHORT).show();
                editText.setText("");
                editText.requestFocus();
            }
            else {
                Toast.makeText(this, "Erro ao salvar nota", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void listarNotas() {
        Cursor c = database.rawQuery("SELECT * FROM notinhas LIMIT ? ", new String[]{"100"});
        c.moveToFirst();
        while (c.isAfterLast()) {
            String s=c.getString((int)c.getColumnIndex("titulo"));
            notas.add(s);
            c.moveToNext();
        }
        //Listagem com ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getApplicationContext(), android.R.layout.simple_list_item_1,android.R.id.text1, notas);
        List.setAdapter(adapter);
    }

}