package com.rnc.backend.entity;

import com.rnc.backend.enums.NivelUrgencia;
import com.rnc.backend.enums.Situacao;
import com.rnc.backend.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class RNC {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_rnc")
    private Long idRnc;

    @Column(name="numero_rnc",nullable = false)
    private Long numeroRnc;

    @Column(nullable = false)
    private String descricao;

    @Column(name="data_criacao",nullable = false,updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name="data_modificacao",nullable = false)
    private LocalDateTime dataModificacao;

    @Column(name = "data_previsao_fechamento",nullable = false)
    private LocalDateTime dataPrevisaoFechamento;

    @Column(name = "data_fechamento",nullable = false)
    private LocalDateTime dataFechamento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Situacao situacao;


    @Column(name="nivel_urgencia",nullable = false)
    @Enumerated(EnumType.STRING)
    private NivelUrgencia nivelUrgencia;

    @ManyToOne
    @JoinColumn(name="tipo_id", nullable = false)
    private Tipo tipo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public RNC() {
    }

    public RNC(Long idRnc, Long numeroRnc, String descricao, LocalDateTime dataCriacao, LocalDateTime dataModificacao, LocalDateTime dataPrevisaoFechamento, LocalDateTime dataFechamento, Status status, Situacao situacao, NivelUrgencia nivelUrgencia, Tipo tipo, Usuario usuario) {
        this.idRnc = idRnc;
        this.numeroRnc = numeroRnc;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
        this.dataPrevisaoFechamento = dataPrevisaoFechamento;
        this.dataFechamento = dataFechamento;
        this.status = status;
        this.situacao = situacao;
        this.nivelUrgencia = nivelUrgencia;
        this.tipo = tipo;
        this.usuario = usuario;
    }

    public Long getIdRnc() {
        return idRnc;
    }

    public void setIdRnc(Long idRnc) {
        this.idRnc = idRnc;
    }

    public Long getNumeroRnc() {
        return numeroRnc;
    }

    public void setNumeroRnc(Long numeroRnc) {
        this.numeroRnc = numeroRnc;
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

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public LocalDateTime getDataPrevisaoFechamento() {
        return dataPrevisaoFechamento;
    }

    public void setDataPrevisaoFechamento(LocalDateTime dataPrevisaoFechamento) {
        this.dataPrevisaoFechamento = dataPrevisaoFechamento;
    }

    public LocalDateTime getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDateTime dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
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

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "RNC{" +
                "idRnc=" + idRnc +
                ", numeroRnc=" + numeroRnc +
                ", descricao='" + descricao + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                ", dataPrevisaoFechamento=" + dataPrevisaoFechamento +
                ", dataFechamento=" + dataFechamento +
                ", status=" + status +
                ", situacao=" + situacao +
                ", nivelUrgencia=" + nivelUrgencia +
                ", tipo=" + tipo +
                ", usuario=" + usuario +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof RNC rnc)) return false;
        return Objects.equals(idRnc, rnc.idRnc);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idRnc);
    }
}
