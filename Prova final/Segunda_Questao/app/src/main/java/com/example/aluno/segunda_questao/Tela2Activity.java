package com.example.aluno.segunda_questao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Tela2Activity extends AppCompatActivity {

    private viewHolder mViewHolder = new viewHolder();
    private double media;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        mViewHolder.editNota1 = findViewById(R.id.edit_nota1);
        mViewHolder.editNota2 = findViewById(R.id.edit_nota2);
        mViewHolder.textMedia = findViewById(R.id.text_media);
        mViewHolder.textSituacao = findViewById(R.id.text_situacao);

        media = getIntent().getDoubleExtra("Media",-1);
        nome = getIntent().getStringExtra("Nome");
        atualizar();
    }

    public void calcular(View view) {
        double nota1,nota2;
        nota1 = (Double.parseDouble(mViewHolder.editNota1.getText().toString()));
        nota2 = (Double.parseDouble(mViewHolder.editNota2.getText().toString()));
        Intent intent = new Intent(this, Tela3Activity.class);
        intent.putExtra("Nota1",nota1);
        intent.putExtra("Nota2",nota2);
        startActivity(intent);
        finish();
    }

    public void atualizar(){
        mViewHolder.textMedia.setText(nome + "Sua media é :" + media);
        if (media >= 7 ){
            mViewHolder.textSituacao.setText("Parabens " + nome + " voce está aprovado.");
        }
        if (media < 7 && media >= 4){
            mViewHolder.textSituacao.setText("Cuidado " + nome + " voce ficou de prova final, voce precisar tirar " + (media - 12) + "para passar.");
        }
        if (media < 4){
            mViewHolder.textSituacao.setText("Sinto muito " + nome + " voce esta reprovado");
        }
    }

    public static class viewHolder{
        EditText editNota1;
        EditText editNota2;
        TextView textMedia;
        TextView textSituacao;

    }
}
