package com.example.aluno.segunda_questao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Tela3Activity extends AppCompatActivity {

    private double nota1;
    private double nota2;
    private double peso1;
    private double peso2;
    private double media;
    private viewHolder mViewHolder = new viewHolder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);
        nota1 = getIntent().getDoubleExtra("Nota1",-1);
        nota2 = getIntent().getDoubleExtra("Nota2",-1);
        this.mViewHolder.textNota1 = findViewById(R.id.text_nota1);
        this.mViewHolder.textNota2 = findViewById(R.id.text_nota2);
        this.mViewHolder.editPeso1 = findViewById(R.id.edit_peso1);
        this.mViewHolder.editPeso2 = findViewById(R.id.edit_peso2);
        atualizar();

    }

    public void calcular(View view) {
        peso1 = Double.parseDouble(mViewHolder.editPeso1.getText().toString());
        peso2 = Double.parseDouble(mViewHolder.editPeso2.getText().toString());
        media = ((nota1 * peso1) + (nota2*peso2)) / (peso1+peso2);
        Intent intent = new Intent(this, Tela2Activity.class);
        intent.putExtra("Media",media);
        startActivity(intent);
        finish();


    }

    public void cancelar(View view) {
        Intent intent = new Intent(this, Tela2Activity.class);
        startActivity(intent);
        finish();
    }

    public void atualizar(){
        String sNota1 = String.valueOf(nota1);
        String sNota2 = String.valueOf(nota2);
        mViewHolder.textNota1.setText(sNota1);
        mViewHolder.textNota2.setText(sNota2);

    }

    public static class viewHolder{
        TextView textNota1;
        TextView textNota2;
        EditText editPeso1;
        EditText editPeso2;
    }
}
