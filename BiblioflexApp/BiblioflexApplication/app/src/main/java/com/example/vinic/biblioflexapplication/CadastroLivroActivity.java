package com.example.vinic.biblioflexapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.vinic.biblioflexapplication.model.ItemLivro;
import com.example.vinic.biblioflexapplication.model.Usuario;

import io.objectbox.Box;

public class CadastroLivroActivity extends AppCompatActivity {

    private viewHolder mViewHolder = new viewHolder();
    private ItemLivro livro = new ItemLivro();
    private Box<Usuario> usuarioBox;
    private long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_livro);
        this.mViewHolder.editNome = findViewById(R.id.edit_nome);
        this.mViewHolder.editAutor = findViewById(R.id.edit_autor);
        this.mViewHolder.editGenero = findViewById(R.id.edit_genero);
        this.mViewHolder.editData = findViewById(R.id.edit_data);
        this.mViewHolder.radioLido = findViewById(R.id.radio_lido);
        this.mViewHolder.radioLendo = findViewById(R.id.radio_lendo);
        this.mViewHolder.radioDesejoLer = findViewById(R.id.radio_desejo_ler);
        this.mViewHolder.ratingEstrela = findViewById(R.id.rating_bar);
        usuarioBox = ((App)getApplication()).getBoxStore().boxFor(Usuario.class);
        id = getIntent().getLongExtra("Id_Usuario",-1);

        mViewHolder.ratingEstrela.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                livro.setAvaliacao(rating);
            }
        });



    }

    public void adicionar(View view) {
        if(!mViewHolder.editNome.getText().toString().equals("") && !mViewHolder.editAutor.getText().toString().equals("") &&
        !mViewHolder.editGenero.getText().toString().equals("") && !mViewHolder.editData.getText().toString().equals("")
        ){
            livro.setNome(mViewHolder.editNome.getText().toString());
            livro.setAutor(mViewHolder.editAutor.getText().toString());
            livro.setGenero(mViewHolder.editGenero.getText().toString());
            livro.setData(mViewHolder.editData.getText().toString());
            if(mViewHolder.radioLido.isChecked()){
                livro.setStatus("Lido");
            }
            if(mViewHolder.radioLendo.isChecked()){
                livro.setStatus("Lendo");
            }
            if(mViewHolder.radioDesejoLer.isChecked()){
                livro.setStatus("Desejo ler");
            }


            Usuario user = usuarioBox.get(id);
            user.livros.add(livro);
            usuarioBox.put(user);
            finish();


        }else{
            Toast.makeText(this,"Alguma área não foi preenciada", Toast.LENGTH_LONG).show();
        }
    }

    public void cancelar(View view) {
        finish();
    }

    private static class viewHolder{
        EditText editNome;
        EditText editAutor;
        EditText editGenero;
        EditText editData;
        RatingBar ratingEstrela;
        RadioButton radioLido;
        RadioButton radioLendo;
        RadioButton radioDesejoLer;
    }
}
