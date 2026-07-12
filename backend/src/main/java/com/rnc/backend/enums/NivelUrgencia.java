package com.rnc.backend.enums;

import org.springframework.security.core.parameters.P;

public enum NivelUrgencia {
    BAIXA("Baixa"),
    MEDIA("Media"),
    ALTA("Alta");

    private String descricao;
    NivelUrgencia(String descricao){
        this.descricao=descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
