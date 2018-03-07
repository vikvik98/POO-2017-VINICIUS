package com.example.vinic.biblioflexapplication.model;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;

/**
 * Created by aluno on 27/02/18.
 */
@Entity
public class Usuario {
    private String email;
    private String senha;
    @Id
    private Long id;
    public ToMany<ItemLivro> livros;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
