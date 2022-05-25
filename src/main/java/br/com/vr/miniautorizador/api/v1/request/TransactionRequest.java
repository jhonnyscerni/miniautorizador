package br.com.vr.miniautorizador.api.v1.request;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionRequest {

    private String numberCard;

    private String password;

    private BigDecimal value;
}
