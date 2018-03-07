package com.example.vinic.biblioflexapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.vinic.biblioflexapplication.model.ItemLivro;
import com.example.vinic.biblioflexapplication.model.Usuario;

import io.objectbox.Box;

public class EditarLivroActivity extends AppCompatActivity {

    private viewHolder mViewHolder = new viewHolder();
    private ItemLivro livro;
    private long idUsuario;
    private long idLivro;
    private Box<Usuario> usuarioBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_livro);
        usuarioBox = ((App)getApplication()).getBoxStore().boxFor(Usuario.class);
        mViewHolder.nomeLivro = findViewById(R.id.edit_nome_livro);
        mViewHolder.autor = findViewById(R.id.edit_autor);
        mViewHolder.genero = findViewById(R.id.edit_genero);
        mViewHolder.data = findViewById(R.id.edit_data);
        mViewHolder.paginaAtual = findViewById(R.id.edit_pagina_atual);
        mViewHolder.paginaTotal = findViewById(R.id.edit_pagina_total);
        mViewHolder.comentario = findViewById(R.id.edit_comentario);
        mViewHolder.dataIni = findViewById(R.id.edit_data_inicio);
        mViewHolder.dataFim = findViewById(R.id.edit_data_final);
        mViewHolder.lido = findViewById(R.id.radio_lido);
        mViewHolder.lendo = findViewById(R.id.radio_lendo);
        mViewHolder.desejoLer = findViewById(R.id.radio_desejo_ler);
        mViewHolder.atualizar = findViewById(R.id.button_atualizar);
        mViewHolder.ratingEstrela = findViewById(R.id.rating_bar);
        idUsuario = getIntent().getLongExtra("Id_usuario", -1);
        idLivro = getIntent().getLongExtra("Id_livro",-1);
        livro = usuarioBox.get(idUsuario).livros.getById(idLivro);
        atualizaInformacoes();

        mViewHolder.atualizar.setOnClickListener((View v) -> {

                    if(!mViewHolder.nomeLivro.getText().toString().equals("") &&
                            !mViewHolder.autor.getText().toString().equals("") &&
                            !mViewHolder.genero.getText().toString().equals("") &&
                            !mViewHolder.data.getText().toString().equals("") &&
                            !mViewHolder.paginaAtual.getText().toString().equals("") &&
                            !mViewHolder.paginaTotal.getText().toString().equals("") &&
                            !mViewHolder.comentario.getText().toString().equals("") &&
                            !mViewHolder.dataIni.getText().toString().equals("") &&
                            !mViewHolder.dataFim.getText().toString().equals(""))
                    {
                        livro.setNome(mViewHolder.nomeLivro.getText().toString());
                        livro.setAutor(mViewHolder.autor.getText().toString());
                        livro.setGenero(mViewHolder.genero.getText().toString());
                        livro.setData(mViewHolder.data.getText().toString());
                        livro.setPaginaAtual(mViewHolder.paginaAtual.getText().toString());
                        livro.setPaginaTotal(mViewHolder.paginaTotal.getText().toString());
                        livro.setComentario(mViewHolder.comentario.getText().toString());
                        livro.setAvaliacao(mViewHolder.ratingEstrela.getRating());
                        livro.setDataIni(mViewHolder.dataIni.getText().toString());
                        livro.setDataFim(mViewHolder.dataFim.getText().toString());
                        if(mViewHolder.lido.isChecked()){
                            livro.setStatus("Lido");
                        }
                        if (mViewHolder.lendo.isChecked()){
                            livro.setStatus("Lendo");
                            livro.setDataFim("Você ainda não terminou de ler este livro.");
                        }
                        if (mViewHolder.desejoLer.isChecked()){
                            livro.setStatus("Desejo ler");
                            livro.setDataIni("Você ainda não inciou a leitura deste livro.");
                            livro.setDataFim("Você ainda não terminou de ler este livro.");
                        }

                        Usuario user = usuarioBox.get(idUsuario);
                        user.livros.add(livro);
                        usuarioBox.put(user);
                        ((App) getApplication()).getBoxStore().boxFor(ItemLivro.class).put(livro);
                        finish();

                    }else{
                        Toast.makeText(this, "Algum campo não foi preenchido",Toast.LENGTH_LONG).show();
                    }
                }

        );

    }

    public void atualizaInformacoes(){
        mViewHolder.nomeLivro.setText(livro.getNome());
        mViewHolder.autor.setText(livro.getAutor());
        mViewHolder.genero.setText(livro.getGenero());
        mViewHolder.data.setText(livro.getData());
        mViewHolder.ratingEstrela.setRating(livro.getAvaliacao());
        if(livro.getPaginaAtual() != null){
            mViewHolder.paginaAtual.setText(livro.getPaginaAtual());
        }
        if(livro.getPaginaTotal() != null){
            mViewHolder.paginaTotal.setText(livro.getPaginaTotal());
        }
        if (livro.getComentario() != null){
            mViewHolder.comentario.setText(livro.getComentario());
        }
        if(livro.getDataIni() != null){
            mViewHolder.dataIni.setText(livro.getDataIni());
        }
        if (livro.getDataFim() != null){
            mViewHolder.dataFim.setText(livro.getDataFim());
        }
    }

    private static class viewHolder {
        EditText nomeLivro;
        EditText autor;
        EditText genero;
        EditText data;
        EditText paginaAtual;
        EditText paginaTotal;
        EditText comentario;
        EditText dataIni;
        EditText dataFim;
        RatingBar ratingEstrela;
        RadioButton lido;
        RadioButton lendo;
        RadioButton desejoLer;
        Button atualizar;
    }
}
