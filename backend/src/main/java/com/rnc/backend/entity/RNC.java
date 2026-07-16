package com.rnc.backend.entity;

import com.rnc.backend.enums.NivelUrgencia;
import com.rnc.backend.enums.Situacao;
import com.rnc.backend.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "rnc")
public class Rnc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rnc")
    private Long idRnc;

    @Column(name="numero_rnc",nullable = false,unique = true)
    private Long numeroRnc;

    @Column(nullable = false)
    private String descricao;

    @Column(name="data_criacao",nullable = false,updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name="data_modificacao",nullable = false)
    private LocalDateTime dataModificacao;

    @Column(name = "data_previsao_finalizacao",nullable = false)
    private LocalDate dataPrevisaoFinalizacao;

    @Column(name = "data_finalizacao")
    private LocalDateTime dataFinalizacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Situacao situacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(name="nivel_urgencia",nullable = false)
    @Enumerated(EnumType.STRING)
    private NivelUrgencia nivelUrgencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tipo_id", nullable = false)
    private Tipo tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id",nullable = false)
    private Usuario usuario;

    @PrePersist
    public void prePersist(){
        dataCriacao = LocalDateTime.now();
        dataModificacao = LocalDateTime.now();
        situacao = Situacao.ABERTO;
        status = Status.ATIVO;
    }

    @PreUpdate
    public void preUpdate() {
        dataModificacao = LocalDateTime.now();
    }

    public Rnc() {
    }

    public Long getIdRnc() {
        return idRnc;
    }

    public Long getNumeroRnc() {
        return numeroRnc;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public LocalDate getDataPrevisaoFinalizacao() {
        return dataPrevisaoFinalizacao;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setDataPrevisaoFinalizacao(LocalDate dataPrevisaoFinalizacao) {
        this.dataPrevisaoFinalizacao = dataPrevisaoFinalizacao;
    }

    public LocalDateTime getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(LocalDateTime dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public NivelUrgencia getNivelUrgencia() {
        return nivelUrgencia;
    }

    public void setNivelUrgencia(NivelUrgencia nivelUrgencia) {
        this.nivelUrgencia = nivelUrgencia;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        return "RNC{" +
                "idRnc=" + idRnc +
                ", numeroRnc=" + numeroRnc +
                ", descricao='" + descricao + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                ", dataPrevisaoFinalizacao=" + dataPrevisaoFinalizacao +
                ", dataFinalizacao=" + dataFinalizacao +
                ", situacao=" + situacao +
                ", status=" + status +
                ", nivelUrgencia=" + nivelUrgencia +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (!(o instanceof Rnc rnc)) return false;
        return Objects.equals(idRnc, rnc.idRnc);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idRnc);
    }
}