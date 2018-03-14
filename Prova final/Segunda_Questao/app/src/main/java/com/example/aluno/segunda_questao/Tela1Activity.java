package com.example.aluno.segunda_questao;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Tela1Activity extends AppCompatActivity {

    private viewHolder mViewHolder = new viewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);
        this.mViewHolder.editNome = findViewById(R.id.edit_nome);


    }

    public void enviar(View view) {
        String nome = mViewHolder.editNome.getText().toString();

        Intent intent = new Intent(this, Tela2Activity.class);
        intent.putExtra("Nome",nome);
        startActivity(intent);
        finish();

    }

    public static class viewHolder{
        EditText editNome;
    }
}
