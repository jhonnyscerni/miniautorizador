package br.com.vr.miniautorizador.services;

import static org.mockito.ArgumentMatchers.any;

import br.com.vr.miniautorizador.api.v1.request.TransactionRequest;
import br.com.vr.miniautorizador.api.v1.response.TransactionCardResponse;
import br.com.vr.miniautorizador.domain.models.Card;
import br.com.vr.miniautorizador.domain.models.Transaction;
import br.com.vr.miniautorizador.domain.repositories.TransactionRespository;
import br.com.vr.miniautorizador.domain.services.CardService;
import br.com.vr.miniautorizador.domain.services.TransactionService;
import br.com.vr.miniautorizador.tests.Factory;
import br.com.vr.miniautorizador.tests.MapperUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TransactionServiceTests {

    @InjectMocks
    private TransactionService service;

    @Mock
    private TransactionRespository repository;

    @Mock
    private CardService cardService;

    private String numberCard;

    private Transaction transaction;

    private TransactionRequest transactionRequest;

    private Card card;

    @BeforeEach
    void setUp() throws Exception {

        service = new TransactionService(repository, MapperUtils.transactionMapper(), cardService);

        numberCard = "123123123123";

        transaction = Factory.createTransaction();
        transactionRequest = Factory.createTransactionRequest();
        card = Factory.createCard();

        Mockito.when(repository.save(any())).thenReturn(transaction);
        Mockito.when(cardService.findByNumberCard(numberCard)).thenReturn(card);
    }

    @Test
    public void insertShouldReturnTransactionCardResponseWhenTransactionExists() {
        TransactionCardResponse result = service.create(transactionRequest);
        Assertions.assertNotNull(result);
    }

}
