package com.example.aluno.questao3application.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aluno.questao3application.App;
import com.example.aluno.questao3application.MainActivity;
import com.example.aluno.questao3application.R;
import com.example.aluno.questao3application.model.Tarefas;

import java.util.List;

import io.objectbox.Box;

/**
 * Created by aluno on 14/03/18.
 */

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.ViewHolder> {

    private List<Tarefas> tarefas;
    private Box<Tarefas> tarefasBox;
    private Context context;

    public TarefaAdapter(List<Tarefas> tarefa, Context context) {
        this.tarefas = tarefa;
        this.context = context;
        tarefasBox = ((App)((MainActivity) context).getApplication())
                .getBoxStore().boxFor(Tarefas.class);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarefacard, parent, false);

        return new ViewHolder(v);
    }



    @Override
    public void onBindViewHolder(TarefaAdapter.ViewHolder holder, int position) {
        final Tarefas tarefa = tarefas.get(position);

        holder.textTitulo.setText(tarefa.getTitulo());
        holder.textDescricao.setText("Descrição : " + tarefa.getDescricao());
        holder.textData.setText("Data limite : " + tarefa.getDataLimite());
        holder.textEstado.setText("Estado : " + tarefa.getEstado());

    }

    @Override
    public int getItemCount() {
        return tarefas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textTitulo;
        public TextView textDescricao;
        public TextView textData;
        public TextView textEstado;

        public ViewHolder(View itemView) {
            super(itemView);

            textTitulo = itemView.findViewById(R.id.text_titulo_tarefa);
            textDescricao = itemView.findViewById(R.id.text_descricao_tarefa);
            textData = itemView.findViewById(R.id.text_data_tarefa);
            textEstado = itemView.findViewById(R.id.text_estado_tarefa);
        }
    }
}
