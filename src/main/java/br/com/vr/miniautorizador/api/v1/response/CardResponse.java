package br.com.vr.miniautorizador.api.v1.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardResponse {

    private String numberCard;

    private String password;
}
