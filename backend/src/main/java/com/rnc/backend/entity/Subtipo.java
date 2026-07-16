package com.rnc.backend.entity;

import com.rnc.backend.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Table(name = "subtipo")
@Entity
public class Subtipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subtipo")
    private Long idSubtipo;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 255)
    private String outro;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_modificacao", nullable = false)
    private LocalDateTime dataModificacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_id", nullable = false)
    private Tipo tipo;

    @PrePersist
    public void prePersist() {
        dataCriacao = LocalDateTime.now();
        dataModificacao = LocalDateTime.now();
        status = Status.ATIVO;
    }

    @PreUpdate
    public void preUpdate() {
        dataModificacao = LocalDateTime.now();
    }

    public Subtipo() {}

    public Long getIdSubtipo() {
        return idSubtipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOutro() {
        return outro;
    }

    public void setOutro(String outro) {
        this.outro = outro;
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

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subtipo subtipo)) return false;
        return Objects.equals(idSubtipo, subtipo.idSubtipo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idSubtipo);
    }

    @Override
    public String toString() {
        return "Subtipo{" +
                "idSubtipo=" + idSubtipo +
                ", nome='" + nome + '\'' +
                ", outro='" + outro + '\'' +
                ", status=" + status +
                ", usuario=" + usuario +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                ", tipo=" + tipo +
                '}';
    }
}