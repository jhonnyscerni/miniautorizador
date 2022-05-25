package br.com.vr.miniautorizador.domain.services;

import br.com.vr.miniautorizador.api.v1.mapper.CardMapper;
import br.com.vr.miniautorizador.api.v1.request.CardRequest;
import br.com.vr.miniautorizador.api.v1.response.AmountResponse;
import br.com.vr.miniautorizador.api.v1.response.CardResponse;
import br.com.vr.miniautorizador.domain.exceptions.EntityNotFoundException;
import br.com.vr.miniautorizador.domain.exceptions.UnprocessableEntity;
import br.com.vr.miniautorizador.domain.models.Card;
import br.com.vr.miniautorizador.domain.models.Transaction;
import br.com.vr.miniautorizador.domain.repositories.CardRepository;
import java.math.BigDecimal;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CardService {

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    public AmountResponse findByAmountResponse(String numberCard) {
        Card card = findByNumberCard(numberCard);
        return cardMapper.toAmount(card);
    }

    public Card findByNumberCard(String numberCard) {
        return cardRepository.findByNumberCard(numberCard)
            .orElseThrow(() -> new EntityNotFoundException("There is no Card registration " + numberCard));

    }

    public CardResponse create(CardRequest cardRequest) {
        log.debug("POST CardRequest cardRequest received {} ", cardRequest.toString());
        existsByNumberCard(cardRequest.getNumberCard());
        Card card = cardMapper.create(cardRequest);
        card.setBalance(new BigDecimal("500.00"));
        cardRepository.save(card);
        log.debug("POST create card saved {} ", cardRequest.getNumberCard());
        log.info("Card create successfully card {} ", cardRequest.getNumberCard());
        return cardMapper.toResponse(card);
    }

    public void existsByNumberCard(String cardNumber) {
        Optional<Card> cardOptional = cardRepository.findByNumberCard(cardNumber);

        if (cardOptional.isPresent()) {
            log.warn("Card Number {} is Already Taken ", cardOptional.get().getNumberCard());
            throw new UnprocessableEntity(
                String.format("Error: Card Number is Already Taken! %s ", cardOptional.get().getNumberCard()));
        }
    }


    public void existsBalance(Transaction transaction, Card card) {
        if (card.getBalance().compareTo(transaction.getValue()) < 0) {
            log.warn("insufficient funds {} ", card.getNumberCard());
            throw new UnprocessableEntity(
                String.format("Error: Cinsufficient funds! %s ", card.getNumberCard()));
        } else {
            card.setBalance(card.getBalance().subtract(transaction.getValue()));
            transaction.setCard(card);
        }
    }

    public void verifyPassword(String cardNumber, String password) {
        Optional<Card> cardOptional = cardRepository.findByNumberCard(cardNumber);
        if (!cardOptional.get().getPassword().equals(password)) {
            log.warn("invalid password {} ", cardOptional.get().getNumberCard());
            throw new UnprocessableEntity(
                String.format("Error: invalid password! %s ", cardOptional.get().getNumberCard()));
        }
    }

    public void balanceValue(Transaction transaction, Card card) {
        existsBalance(transaction, card);
    }
}
