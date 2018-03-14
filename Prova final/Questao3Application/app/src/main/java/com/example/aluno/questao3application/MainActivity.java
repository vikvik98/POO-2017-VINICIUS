package com.example.aluno.questao3application;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.aluno.questao3application.adapters.TarefaAdapter;
import com.example.aluno.questao3application.model.Tarefas;

import java.util.List;

import io.objectbox.Box;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Tarefas> tarefas;
    private Box<Tarefas> tarefasBox;
    private Context context = this;
    private TarefaAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tarefasBox = ((App)getApplication()).getBoxStore().boxFor(Tarefas.class);
        recyclerView = findViewById(R.id.rv_tarefas);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();

        adapter = new TarefaAdapter(tarefasBox.getAll(),this);

        recyclerView.setAdapter(adapter);
    }

    public void novaTarefe(View view) {

        Intent intent = new Intent(this, TarefaCadastroActivity.class);
        startActivity(intent);

    }
}
