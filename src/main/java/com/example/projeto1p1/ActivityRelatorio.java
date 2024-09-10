package com.example.projeto1p1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityRelatorio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio);

        String nome = getIntent().getStringExtra("nome");
        long anos = getIntent().getLongExtra("data", 0);

        TextView relatorio = findViewById(R.id.idRelatorio);

        if (anos == 15){
            relatorio.setText(nome + ", com " +anos+ " anos, pode tirar titulo de eleitor");
        } else if (anos >= 16 && anos < 18) {
            relatorio.setText(nome + ", com " +anos+ " anos, pode tirar titulo de eleitor e pode votar");
        } else if (anos >= 18 && anos < 70) {
            relatorio.setText(nome + ", com " +anos+ " anos, deve votar");
        }else if (anos>= 70){
            relatorio.setText(nome + ", com " +anos+ " anos, pode votar");
        }
    }

    public void compartilhar (View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,
                ((TextView)findViewById(R.id.idRelatorio)).getText().toString());
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent,
                "compartilhando com..."));
    }

}