package br.com.vr.miniautorizador.api.v1.mapper;

import br.com.vr.miniautorizador.api.v1.request.CardRequest;
import br.com.vr.miniautorizador.api.v1.response.AmountResponse;
import br.com.vr.miniautorizador.api.v1.response.CardResponse;
import br.com.vr.miniautorizador.domain.models.Card;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper {

    AmountResponse toAmount(Card entity);

    Card create(CardRequest userRequest);

    CardResponse toResponse(Card card);
}
