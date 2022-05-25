package br.com.vr.miniautorizador.api.v1.mapper;

import br.com.vr.miniautorizador.api.v1.request.TransactionRequest;
import br.com.vr.miniautorizador.api.v1.response.TransactionCardResponse;
import br.com.vr.miniautorizador.domain.models.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @Mapping(target = "card.numberCard",source = "transactionRequest.numberCard")
    @Mapping(target = "card.password",source = "transactionRequest.password")
    Transaction create(TransactionRequest transactionRequest);

    @Mapping(target = "password",source = "card.password")
    @Mapping(target = "numberCard",source = "card.numberCard")
    @Mapping(target = "balance",source = "card.balance")
    TransactionCardResponse toResponse(Transaction transaction);
    }
