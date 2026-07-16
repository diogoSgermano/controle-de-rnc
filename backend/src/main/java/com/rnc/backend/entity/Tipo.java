package com.rnc.backend.entity;

import com.rnc.backend.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table(name = "tipo")
@Entity
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo")
    private Long idTipo;

    @Column(nullable = false, length=100)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name="data_criacao",nullable = false,updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name="data_modificacao",nullable = false)
    private LocalDateTime dataModificacao;

    @OneToMany(mappedBy = "tipo")
    private List<Subtipo> subtipos = new ArrayList<>();

    @OneToMany(mappedBy = "tipo")
    private List<Rnc> rncs = new ArrayList<>();

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

    public Tipo(){}

    public Long getIdTipo() {
        return idTipo;
    }

    public String getNome() {
        return nome;
    }

    public List<Subtipo> getSubtipos() {
        return subtipos;
    }

    public List<Rnc> getRncs() {
        return rncs;
    }

    public void setIdTipo(Long idTipo) {
        this.idTipo = idTipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    @Override
    public boolean equals(Object o) {
        if(this==o)return true;
        if (!(o instanceof Tipo tipo)) return false;
        return Objects.equals(idTipo, tipo.idTipo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idTipo);
    }

    @Override
    public String toString() {
        return "Tipo{" +
                "idTipo=" + idTipo +
                ", nome='" + nome + '\'' +
                ", status=" + status +
                ", usuario=" + usuario +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                '}';
    }
}
