package com.example.vinic.biblioflexapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vinic.biblioflexapplication.model.Usuario;
import com.example.vinic.biblioflexapplication.model.Usuario_;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.query.QueryBuilder;

public class LoginActivity extends AppCompatActivity {
    private Box<Usuario> usuarioBox;

    private viewHolder mViewHolder = new viewHolder();
    private long id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usuarioBox = ((App)getApplication()).getBoxStore().boxFor(Usuario.class);
        this.mViewHolder.editEmail = findViewById(R.id.edit_email);
        this.mViewHolder.editSenha = findViewById(R.id.edit_senha);

    }

    public void cadastro(View view) {
        Intent cadastro = new Intent(this, CadastroActivity.class);
        startActivity(cadastro);
    }

    public void logar(View view) {
        QueryBuilder<Usuario> builder = usuarioBox.query();
        builder.equal(Usuario_.email,mViewHolder.editEmail.getText().toString());
        List<Usuario> usuarios = builder.build().find();
        if (usuarios.isEmpty()){
            Toast.makeText(this,"Email não cadastrado", Toast.LENGTH_LONG).show();
        }else{
            if (usuarios.get(0).getSenha().equals(mViewHolder.editSenha.getText().toString())){
                Intent intent = new Intent(this, LivrosActivity.class);
                intent.putExtra("Id_Usuario",usuarios.get(0).getId());
                startActivity(intent);
                finish();
            }else{
                Toast.makeText(this,"Senha incorreta",Toast.LENGTH_LONG).show();
            }

        }
    }

    private static class viewHolder{
        EditText editEmail;
        EditText editSenha;
    }
}
