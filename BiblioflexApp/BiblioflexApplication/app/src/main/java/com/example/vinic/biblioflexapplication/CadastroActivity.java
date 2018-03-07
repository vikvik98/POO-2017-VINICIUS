package com.example.vinic.biblioflexapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vinic.biblioflexapplication.model.Usuario;
import com.example.vinic.biblioflexapplication.model.Usuario_;

import io.objectbox.Box;
import io.objectbox.query.QueryBuilder;

public class CadastroActivity extends AppCompatActivity {

    private viewHolder mViewHolder = new viewHolder();
    private Usuario usuario = new Usuario();
    private Box<Usuario> usuarioBox;
    private long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        this.mViewHolder.editEmail = findViewById(R.id.edit_email);
        this.mViewHolder.editSenha = findViewById(R.id.edit_senha);
        this.mViewHolder.editCoSenha = findViewById(R.id.edit_co_senha);
        usuarioBox = ((App)getApplication()).getBoxStore().boxFor(Usuario.class);


    }

    public void cancelar(View view) {
        startActivity(new Intent(this,LoginActivity.class));
    }

    public void cadastrar(View view) {
        if (mViewHolder.editEmail.getText().toString().equals("") || mViewHolder.editSenha.getText().toString().equals("")){
            Toast.makeText(this,"Um dos campos está vazio",Toast.LENGTH_LONG).show();
        }else{
            if(!mViewHolder.editSenha.getText().toString().equals( mViewHolder.editCoSenha.getText().toString())){
                Toast.makeText(this,"As senhas não batem", Toast.LENGTH_LONG).show();
            }else{
                QueryBuilder<Usuario> builder = usuarioBox.query();
                builder.equal(Usuario_.email,mViewHolder.editEmail.getText().toString());
                if(builder.build().find().isEmpty()){
                    usuario.setEmail(mViewHolder.editEmail.getText().toString());
                    usuario.setSenha(mViewHolder.editSenha.getText().toString());
                    id = usuarioBox.put(usuario);
                    Toast.makeText(this,"Você foi cadastrado", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, LivrosActivity.class);
                    intent.putExtra("Id_Usuario",id);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(this,"Email já está cadastrado",Toast.LENGTH_LONG).show();
                }

            }
        }


    }

    private static class viewHolder{
        EditText editEmail;
        EditText editSenha;
        EditText editCoSenha;
    }
}
