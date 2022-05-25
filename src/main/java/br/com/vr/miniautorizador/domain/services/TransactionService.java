package br.com.vr.miniautorizador.domain.services;

import br.com.vr.miniautorizador.api.v1.mapper.TransactionMapper;
import br.com.vr.miniautorizador.api.v1.request.TransactionRequest;
import br.com.vr.miniautorizador.api.v1.response.TransactionCardResponse;
import br.com.vr.miniautorizador.domain.models.Card;
import br.com.vr.miniautorizador.domain.models.Transaction;
import br.com.vr.miniautorizador.domain.repositories.TransactionRespository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class TransactionService {

    private final TransactionRespository transactionRespository;

    private final TransactionMapper transactionMapper;

    private final CardService cardService;

    @Transactional
    public TransactionCardResponse create(TransactionRequest transactionRequest) {
        log.debug("POST TransactionRequest transactionRequest received {} ", transactionRequest.toString());
        Card card = cardService.findByNumberCard(transactionRequest.getNumberCard());
        cardService.verifyPassword(transactionRequest.getNumberCard(), transactionRequest.getPassword());
        Transaction transaction = transactionMapper.create(transactionRequest);
        cardService.balanceValue(transaction, card);
        transactionRespository.save(transaction);
        log.debug("POST create card saved {} ", transactionRequest.getNumberCard());
        log.info("Card create successfully card {} ", transactionRequest.getNumberCard());
        return transactionMapper.toResponse(transaction);
    }
}
