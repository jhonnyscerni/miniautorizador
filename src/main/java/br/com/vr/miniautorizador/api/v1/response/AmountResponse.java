package br.com.vr.miniautorizador.api.v1.response;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AmountResponse {

    private BigDecimal balance;
}
