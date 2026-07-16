package com.rnc.backend.entity;

import com.rnc.backend.enums.Situacao;
import com.rnc.backend.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "setor")
public class Setor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_setor")
    private Long idSetor;

    @Column(nullable = false, length = 150)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usuario_id", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "setor")
    private List<Usuario> usuarios = new ArrayList<>();

    @Column(name="data_criacao",nullable = false,updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name="data_modificacao",nullable = false)
    private LocalDateTime dataModificacao;

    @PrePersist
    public void prePersist(){
        dataCriacao = LocalDateTime.now();
        dataModificacao = LocalDateTime.now();
        status = Status.ATIVO;
    }

    @PreUpdate
    public void preUpdate() {
        dataModificacao = LocalDateTime.now();
    }


    public Setor() {}

    public List<Usuario> getUsuarios() {
        return usuarios;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdSetor() {
        return idSetor;
    }

    @Override
    public String toString() {
        return "Setor{" +
                "idSetor=" + idSetor +
                ", nome='" + nome + '\'' +
                ", status=" + status +
                ", usuario=" + usuario +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this==o)return true;
        if (!(o instanceof Setor setor)) return false;
        return Objects.equals(idSetor, setor.idSetor);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idSetor);
    }
}