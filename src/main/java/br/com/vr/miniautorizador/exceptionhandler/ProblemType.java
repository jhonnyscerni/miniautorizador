package br.com.vr.miniautorizador.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

    DADOS_INVALIDOS("/dados-invalidos", "invalid data"),
    ACESSO_NEGADO("/acesso-negado", "Access denied"),
    ERRO_DE_SISTEMA("/erro-de-sistema", "System error"),
    PARAMETRO_INVALIDO("/parametro-invalido", "invalid parameter"),
    MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "incomprehensible message"),
    RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Resource not found"),
    ENTIDADE_EM_USO("/entidade-em-uso", "Entity in use"),
    ERRO_NEGOCIO("/erro-negocio", "Business rule violation");

    private String title;
    private String uri;

    ProblemType(String path, String title) {
        this.uri = "https://project" + path;
        this.title = title;
    }
}
