package com.example.aluno.questao3application.model;

import android.support.annotation.IntDef;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by aluno on 14/03/18.
 */

@Entity
public class Tarefas {

    @Id
    private long id;
    private String titulo;
    private String descricao;
    private String dataLimite;
    private String estado;

    public String getTitulo() {
        return titulo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(String dataLimite) {
        this.dataLimite = dataLimite;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
