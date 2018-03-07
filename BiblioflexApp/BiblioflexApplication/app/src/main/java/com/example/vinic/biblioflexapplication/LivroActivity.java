package com.example.vinic.biblioflexapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.vinic.biblioflexapplication.model.ItemLivro;
import com.example.vinic.biblioflexapplication.model.Usuario;

import io.objectbox.Box;

public class LivroActivity extends AppCompatActivity {

    viewHolder mViewHolder = new viewHolder();
    ItemLivro livro = new ItemLivro();
    Context context = this;
    private long idUsuario;
    private long idLivro;
    private Box<Usuario> usuarioBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livro);
        usuarioBox = ((App)getApplication()).getBoxStore().boxFor(Usuario.class);
        Toolbar myToolbar = findViewById(R.id.my_toolbar_livro);
        setSupportActionBar(myToolbar);
        mViewHolder.textNome = findViewById(R.id.text_nome_livro);
        mViewHolder.textAutor = findViewById(R.id.text_autor);
        mViewHolder.textGenero = findViewById(R.id.text_genero);
        mViewHolder.ratingEstrela = findViewById(R.id.rating_bar);
        mViewHolder.textProgresso = findViewById(R.id.text_progressao);
        mViewHolder.textData = findViewById(R.id.text_data);
        mViewHolder.textStatus = findViewById(R.id.text_status);
        mViewHolder.textPaginaAtual = findViewById(R.id.text_pagina_atual);
        mViewHolder.textPaginaTotal = findViewById(R.id.text_pagina_total);
        mViewHolder.textComentario = findViewById(R.id.text_comentario);
        mViewHolder.progressProg = findViewById(R.id.progress_progresso);
        mViewHolder.textDataIni = findViewById(R.id.text_data_ini);
        mViewHolder.textDataFim = findViewById(R.id.text_data_fim);
        livro = (ItemLivro) getIntent().getSerializableExtra("Livro");
        idUsuario = getIntent().getLongExtra("Id_usuario",-1);

    }

    @Override
    protected void onResume() {
        livro = usuarioBox.get(idUsuario).livros.getById(livro.getId());
        atualizaInformacoes();
        super.onResume();
    }

    public void voltar(View view) {
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mMenuInflater = getMenuInflater();
        mMenuInflater.inflate(R.menu.livro_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.item_excluir_livro){
            AlertDialog.Builder builderDialog = new AlertDialog.Builder(this);
            builderDialog.setTitle("Excluir");
            builderDialog.setMessage("Você deseja realmente excluir este livro?");
            builderDialog.setNegativeButton("Não",null);
            builderDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    idLivro = livro.getId();
                    Usuario user = usuarioBox.get(idUsuario);
                    user.livros.removeById(idLivro);
                    usuarioBox.put(user);
                    finish();
                }
            });
            builderDialog.create().show();
        }
        if(item.getItemId() == R.id.item_editar_livro){
            Intent intent = new Intent(this,EditarLivroActivity.class);
            intent.putExtra("Id_livro",livro.getId()).putExtra("Id_usuario",idUsuario);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void atualizaInformacoes(){
        mViewHolder.textNome.setText(livro.getNome());
        mViewHolder.textAutor.setText("Autor : " + livro.getAutor());
        mViewHolder.textGenero.setText("Gênero : " + livro.getGenero());
        mViewHolder.textData.setText("Data de publicação : " + livro.getData());
        mViewHolder.textStatus.setText("Status : " + livro.getStatus());
        mViewHolder.textPaginaAtual.setText("Pagina atual : "+ livro.getPaginaAtual());



        if (livro.getPaginaAtual() == null){
            mViewHolder.textPaginaAtual.setText("Pagina atual : Você ainda não passou a pagina atual" );
        }else{
            mViewHolder.textPaginaTotal.setText("Pagina total : "+ livro.getPaginaAtual());
        }
        if (livro.getPaginaTotal() == null){
            mViewHolder.textPaginaTotal.setText("Pagina total : Você ainda não passou a pagina total" );
        }else{
            mViewHolder.textPaginaTotal.setText("Pagina total : "+ livro.getPaginaTotal());
        }
        if (livro.getComentario() == null){
            mViewHolder.textComentario.setText("Você ainda não comentou sobre o livro" );
        }else{
            mViewHolder.textComentario.setText(livro.getComentario());
        }
        if (livro.getPaginaAtual() != null && livro.getPaginaTotal() != null){
            mViewHolder.textProgresso.setText("Progresso : " + livro.getPaginaAtual() + "/" + livro.getPaginaTotal());
        }else{
            mViewHolder.textProgresso.setText("Progresso : Por favor, passse uma pagina atual e total");
        }
        if(livro.getDataIni() == null){
            mViewHolder.textDataIni.setText("Data do inicio da leitura : Você ainda não atualizou está informação.");
        }else{
            mViewHolder.textDataIni.setText("Data do inicio da leitura : " + livro.getDataIni());
        }
        if(livro.getDataFim() == null){
            mViewHolder.textDataFim.setText("Data do inicio da leitura : Você ainda não atualizou está informação.");
        }else{
            mViewHolder.textDataFim.setText("Data da finalização da leitura : " + livro.getDataFim());
        }

        if(livro.getPaginaAtual() != null && livro.getPaginaTotal() != null){
            mViewHolder.progressProg.setProgress(Integer.parseInt(livro.getPaginaAtual()));
            mViewHolder.progressProg.setMax(Integer.parseInt(livro.getPaginaTotal()));
        }

        mViewHolder.ratingEstrela.setRating(livro.getAvaliacao());

    }



    private static class viewHolder{
        TextView textNome;
        TextView textAutor;
        TextView textGenero;
        TextView textData;
        RatingBar ratingEstrela;
        ProgressBar progressProg;
        TextView textDataIni;
        TextView textDataFim;
        TextView textProgresso;
        TextView textStatus;
        TextView textPaginaAtual;
        TextView textPaginaTotal;
        TextView textComentario;

    }
}
