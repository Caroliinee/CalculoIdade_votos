package com.example.projeto1p1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class MainActivity extends AppCompatActivity {

    private EditText data, nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.idNome);
        data = findViewById(R.id.idData);

    }

    public void confirmar (View view){
        String txtData = data.getText().toString();
        long anos = Period.between(LocalDate.parse(txtData,
                DateTimeFormatter.ofPattern("dd/MM/yyyy")),LocalDate.now()).get(ChronoUnit.YEARS);
        Intent intent = new Intent(getApplicationContext(),ActivityRelatorio.class);
        intent.putExtra("nome",nome.getText().toString());
        intent.putExtra("data", anos);
        startActivity(intent);
    }

}