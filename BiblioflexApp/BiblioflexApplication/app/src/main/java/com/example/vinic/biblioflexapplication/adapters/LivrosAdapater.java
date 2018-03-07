package com.example.vinic.biblioflexapplication.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.vinic.biblioflexapplication.App;
import com.example.vinic.biblioflexapplication.EditarLivroActivity;
import com.example.vinic.biblioflexapplication.model.ItemLivro;
import com.example.vinic.biblioflexapplication.LivroActivity;
import com.example.vinic.biblioflexapplication.LivrosActivity;
import com.example.vinic.biblioflexapplication.R;
import com.example.vinic.biblioflexapplication.model.Usuario;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.Box;

/**
 * Created by aluno on 01/03/18.
 */

public class LivrosAdapater extends RecyclerView.Adapter<LivrosAdapater.ViewHolder> {

    private List<ItemLivro> livros;
    private Box<Usuario> usuarioBox;
    private Context context;
    private Usuario user;
    private long idUsuario;
    private long idLivro;

    public LivrosAdapater(List<ItemLivro> itemLivros, Context context, long id) {
        this.livros = itemLivros;
        this.context = context;

        idUsuario = id;

        usuarioBox = ((App)((LivrosActivity) context).getApplication())
                .getBoxStore().boxFor(Usuario.class);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_livro, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final ItemLivro itemLivro = livros.get(position);

        holder.textViewNomeLivro.setText(itemLivro.getNome());
        holder.textViewAutor.setText("Autor : " + itemLivro.getAutor());
        holder.textViewGenero.setText("Gênero : " + itemLivro.getGenero());
        holder.textViewAnoP.setText("Ano de publicação : " + itemLivro.getData());
        holder.ratingEstrela.setRating(itemLivro.getAvaliacao());
        holder.textViewStatus.setText("Status : " + itemLivro.getStatus());
        if(itemLivro.getPaginaAtual() != null && itemLivro.getPaginaTotal() != null){
            holder.progressProg.setProgress(Integer.parseInt(itemLivro.getPaginaAtual()));
            holder.progressProg.setMax(Integer.parseInt(itemLivro.getPaginaTotal()));
        }

        holder.itemView.setOnLongClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(context, holder.itemView);
            popupMenu.getMenuInflater().inflate(R.menu.carview_menu, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    if(item.getItemId() == R.id.item_excluir){
                        AlertDialog.Builder builderDialog = new AlertDialog.Builder(context);
                        builderDialog.setTitle("Excluir");
                        builderDialog.setMessage("Você deseja realmente excluir este livro?");
                        builderDialog.setNegativeButton("Não",null);
                        builderDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                idLivro = itemLivro.getId();
                                user = usuarioBox.get(idUsuario);
                                user.livros.removeById(idLivro);
                                livros.remove(itemLivro);
                                usuarioBox.put(user);
                                notifyItemRemoved(position);
                                notifyItemRangeChanged(position,getItemCount());
                            }
                        });
                        builderDialog.create().show();
                    }
                    if(item.getItemId() == R.id.item_editar){
                        Intent intent = new Intent(context,EditarLivroActivity.class);
                        intent.putExtra("Id_livro",itemLivro.getId()).putExtra("Id_usuario",idUsuario);
                        context.startActivity(intent);
                    }

                    return true;
                }
            });
            popupMenu.show();
            return true;
        });

        holder.itemView.setOnClickListener((view) -> {
            Usuario user = new Usuario();
            ItemLivro livro = new ItemLivro();
            idLivro = itemLivro.getId();
            user = usuarioBox.get(idUsuario);
            livro = user.livros.getById(idLivro);
            Intent intent = new Intent(context, LivroActivity.class);
            intent.putExtra("Livro",livro).putExtra("Id_usuario",user.getId());
            context.startActivity(intent);

        });

    }



    @Override
    public int getItemCount() {
        return livros.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewNomeLivro;
        public TextView textViewAutor;
        public TextView textViewGenero;
        public TextView textViewAnoP;
        public TextView textViewStatus;
        public RatingBar ratingEstrela;
        public ProgressBar progressProg;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewNomeLivro = itemView.findViewById(R.id.text_nome_livro);
            textViewAutor = itemView.findViewById(R.id.text_autor);
            textViewGenero = itemView.findViewById(R.id.text_genero);
            textViewAnoP = itemView.findViewById(R.id.text_ano_p);
            textViewStatus = itemView.findViewById(R.id.text_status);
            ratingEstrela = itemView.findViewById(R.id.rating_bar);
            progressProg = itemView.findViewById(R.id.progress_progresso);

        }
    }

    public void setFilter(ArrayList<ItemLivro> livroFiltrados){
        livros = new ArrayList<>();
        livros.addAll(livroFiltrados);
        notifyDataSetChanged();
    }


}
