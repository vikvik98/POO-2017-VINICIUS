package com.example.vinic.biblioflexapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import com.example.vinic.biblioflexapplication.adapters.LivrosAdapater;
import com.example.vinic.biblioflexapplication.model.ItemLivro;
import com.example.vinic.biblioflexapplication.model.Usuario;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.Box;

public class LivrosActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, SearchView.OnQueryTextListener {

    private RecyclerView recyclerView;
    private LivrosAdapater adapter;
    private List<ItemLivro> itemLivros;
    private Box<Usuario> usuarioBox;
    private long id;
    private Usuario usuario;
    private Context context = this;
    private DrawerLayout mDrawerLoyout;
    private ActionBarDrawerToggle mToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livros);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        usuarioBox = ((App)getApplication()).getBoxStore().boxFor(Usuario.class);
        recyclerView = findViewById(R.id.rv_livros);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        id = getIntent().getLongExtra("Id_Usuario",-1);
        mDrawerLoyout = findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLoyout,R.string.abrir,R.string.fechar);
        mDrawerLoyout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        itemLivros = usuarioBox.get(id).livros;


    }

    @Override
    protected void onResume() {
        super.onResume();
        usuario = usuarioBox.get(id);

        adapter = new LivrosAdapater(usuarioBox.get(id).livros,this, id);

        recyclerView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mMenuInflater = getMenuInflater();
        mMenuInflater.inflate(R.menu.my_menu, menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.pesquisa_menu, menu);
        MenuItem item = menu.findItem(R.id.item_pesquisar);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_sair){
            AlertDialog.Builder builderDialog = new AlertDialog.Builder(this);
            builderDialog.setTitle("Sair");
            builderDialog.setMessage("Você deseja realmente sair?");
            builderDialog.setNegativeButton("Não",null);
            builderDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(context,LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
            builderDialog.create().show();
        }
        if(mToggle.onOptionsItemSelected(item)){

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void novoLivro(View view) {
        Intent intent = new Intent(this, CadastroLivroActivity.class);
        intent.putExtra("Id_Usuario",id);
        startActivity(intent);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int idMenu = item.getItemId();
        if (idMenu == R.id.item_todos){
            itemLivros = usuarioBox.get(id).livros;
            adapter = new LivrosAdapater(itemLivros,this, id);

            recyclerView.setAdapter(adapter);
        }
        if (idMenu == R.id.item_lido){
            itemLivros.clear();
            for (ItemLivro livro : usuarioBox.get(id).livros){
                if (livro.getStatus().equals("Lido")){
                    itemLivros.add(livro);
                    adapter = new LivrosAdapater(itemLivros,this, id);

                    recyclerView.setAdapter(adapter);

                }
            }
        }
        if (idMenu == R.id.item_lendo){
            itemLivros.clear();
            for (ItemLivro livro : usuarioBox.get(id).livros){
                if (livro.getStatus().equals("Lendo")){
                    itemLivros.add(livro);
                    adapter = new LivrosAdapater(itemLivros,this, id);

                    recyclerView.setAdapter(adapter);
                }
            }
        }
        if (idMenu == R.id.item_desejo){
            itemLivros.clear();
            for (ItemLivro livro : usuarioBox.get(id).livros){
                if (livro.getStatus().equals("Desejo ler")){
                    itemLivros.add(livro);
                    adapter = new LivrosAdapater(itemLivros,this, id);

                    recyclerView.setAdapter(adapter);
                }
            }
        }
        return true;


    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        newText = newText.toLowerCase();
        ArrayList<ItemLivro> novaLista = new ArrayList<>();

        for (ItemLivro livro : usuarioBox.get(id).livros){
            String nome = livro.getNome().toLowerCase();
            if(nome.contains(newText)){
                novaLista.add(livro);
            }
        }

        adapter.setFilter(novaLista);


        return true;
    }
}
