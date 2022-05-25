package br.com.vr.miniautorizador.api.v1.controllers;

import br.com.vr.miniautorizador.api.v1.openapi.CardOpenApi;
import br.com.vr.miniautorizador.api.v1.request.CardRequest;
import br.com.vr.miniautorizador.api.v1.response.AmountResponse;
import br.com.vr.miniautorizador.api.v1.response.CardResponse;
import br.com.vr.miniautorizador.domain.services.CardService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/cards", produces = MediaType.APPLICATION_JSON_VALUE)
public class CardController implements CardOpenApi {

    private final CardService cardService;

    @Override
    @GetMapping(value = "/{numberCard}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AmountResponse> findById(@PathVariable String numberCard) {
        return ResponseEntity.ok().body(cardService.findByAmountResponse(numberCard));
    }

    @Override
    @PostMapping
    public ResponseEntity<CardResponse> create(@RequestBody @Valid CardRequest cardRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cardService.create(cardRequest));
    }
}
