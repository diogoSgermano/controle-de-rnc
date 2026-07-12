package com.rnc.backend.enums;

public enum Situacao {
    ABERTO("Aberto"),
    VISUALIZADA("Visualizada"),
    EM_ANDAMENTO("Em andamento"),
    ATRASADA("Atrasada"),
    FINALIZADA("Finalizada"),
    FINALIZADA_COM_ATRASO ("Finalizada com atraso");

    private final String descricao;
    Situacao(String descricao){
        this.descricao=descricao;
    }

    public String getDescricao(){
        return descricao;
    }

}
