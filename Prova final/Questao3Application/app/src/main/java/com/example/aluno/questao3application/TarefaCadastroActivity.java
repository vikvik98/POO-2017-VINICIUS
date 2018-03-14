package com.example.aluno.questao3application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aluno.questao3application.model.Tarefas;

import io.objectbox.Box;

public class TarefaCadastroActivity extends AppCompatActivity {

    private viewHolder mViewHolder = new viewHolder();
    private Tarefas tarefa = new Tarefas();
    private Box<Tarefas> tarefasBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa_cadastro);
        tarefasBox = ((App)getApplication()).getBoxStore().boxFor(Tarefas.class);
        mViewHolder.editTitulo = findViewById(R.id.edit_titulo);
        mViewHolder.editDescricao = findViewById(R.id.edit_descricao);
        mViewHolder.editData = findViewById(R.id.data);
    }

    public void criar(View view) {
        if(!mViewHolder.editTitulo.equals("") && !mViewHolder.editDescricao.equals("") &&
                !mViewHolder.editData.equals("")){
            tarefa.setTitulo(mViewHolder.editTitulo.getText().toString());
            tarefa.setDescricao(mViewHolder.editDescricao.getText().toString());
            tarefa.setDataLimite(mViewHolder.editData.getText().toString());
            tarefa.setEstado("A fazer");
            tarefasBox.put(tarefa);
            finish();
        }else{
            Toast.makeText(this,"Alguma das areas não foi preenchida", Toast.LENGTH_LONG).show();
        }
    }

    private static class viewHolder{
        EditText editTitulo;
        EditText editDescricao;
        EditText editData;
    }
}
