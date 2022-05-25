package br.com.vr.miniautorizador.tests;

import br.com.vr.miniautorizador.api.v1.mapper.CardMapper;
import br.com.vr.miniautorizador.api.v1.mapper.TransactionMapper;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;

@AllArgsConstructor
public final class MapperUtils {

    public static TransactionMapper transactionMapper() {
        return Mappers.getMapper(TransactionMapper.class);
    }

    public static CardMapper cardMapper() {
        return Mappers.getMapper(CardMapper.class);
    }

}