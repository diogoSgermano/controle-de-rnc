package com.rnc.backend.enums;

import jakarta.persistence.Enumerated;

public enum Nivel {
    ADMINISTRADOR("Administrador"),
    ASSISTENTE("Assistente");

    private String descricao;

    Nivel(String descricao){
        this.descricao=descricao;
    }

    public String getDescricao(){
        return descricao;
    }


}
