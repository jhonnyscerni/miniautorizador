package br.com.vr.miniautorizador.response;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AmountResponse {

    private BigDecimal balance;
}
