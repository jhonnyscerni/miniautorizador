package br.com.vr.miniautorizador.services;

import br.com.vr.miniautorizador.api.v1.response.AmountResponse;
import br.com.vr.miniautorizador.domain.exceptions.EntityNotFoundException;
import br.com.vr.miniautorizador.domain.models.Card;
import br.com.vr.miniautorizador.domain.models.Transaction;
import br.com.vr.miniautorizador.domain.repositories.CardRepository;
import br.com.vr.miniautorizador.domain.services.CardService;
import br.com.vr.miniautorizador.tests.Factory;
import br.com.vr.miniautorizador.tests.MapperUtils;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class CardServiceTests {

    @InjectMocks
    private CardService service;

    @Mock
    private CardRepository cardRepository;

    private String numberCard;

    private String numberCardNoExist;

    private Transaction transaction;

    private Card card;

    @BeforeEach
    void setUp() throws Exception {

        service = new CardService(cardRepository, MapperUtils.cardMapper());

        numberCard = "123123123123";

        numberCardNoExist = "1111111111111111111";

        transaction = Factory.createTransaction();
        card = Factory.createCard();

        Mockito.when(cardRepository.findByNumberCard(numberCardNoExist)).thenThrow(EntityNotFoundException.class);
        Mockito.when(cardRepository.findByNumberCard(numberCard)).thenReturn(Optional.of(card));

    }

    @Test
    public void findByNumberCardShouldThrowEntityNotFoundExceptionWhenNumberCardDoesNotExists() {
        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            service.findByNumberCard(numberCardNoExist);
        });
    }

    @Test
    public void findByNumberCardReturnCardWhenNumberCardExists() {

        Card result = service.findByNumberCard(numberCard);

        Assertions.assertNotNull(result);

        Mockito.verify(cardRepository).findByNumberCard(numberCard);
    }

    @Test
    public void findByAmountResponseNumberCardReturnAmountResponseWhenNumberCardExists(){

        AmountResponse result = service.findByAmountResponse(numberCard);
        Assertions.assertNotNull(result);
    }

    @Test
    public void existsByNumberCardWhenNumberCardNoExists(){
        Optional<Card> cardOptional = cardRepository.findByNumberCard(numberCard);
        Assertions.assertNotNull(cardOptional);
    }



}
