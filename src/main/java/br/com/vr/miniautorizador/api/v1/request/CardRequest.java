package br.com.vr.miniautorizador.api.v1.request;

import lombok.Data;

@Data
public class CardRequest {

    private String numberCard;

    private String password;
}
