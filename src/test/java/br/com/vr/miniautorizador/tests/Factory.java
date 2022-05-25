package br.com.vr.miniautorizador.tests;

import br.com.vr.miniautorizador.api.v1.request.TransactionRequest;
import br.com.vr.miniautorizador.domain.models.Card;
import br.com.vr.miniautorizador.domain.models.Transaction;
import java.math.BigDecimal;

public class Factory {

    public static Card createCard() {
        return new Card(1L, "1234123412341234", "123", new BigDecimal("500.00"));
    }

    public static Transaction createTransaction() {
        Transaction transaction = new Transaction(1L, BigDecimal.TEN);
        transaction.setCard(createCard());
        return transaction;
    }

    public static TransactionRequest createTransactionRequest() {
        return new TransactionRequest("1234123412341234", "123", new BigDecimal("10.00"));
    }
}
