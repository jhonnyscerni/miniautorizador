package br.com.vr.miniautorizador.api.v1.controllers;

import br.com.vr.miniautorizador.api.v1.openapi.TransactionOpenApi;
import br.com.vr.miniautorizador.api.v1.request.TransactionRequest;
import br.com.vr.miniautorizador.domain.services.TransactionService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
public class TransactionController implements TransactionOpenApi {

    private final TransactionService transactionService;

    @Override
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid TransactionRequest transactionRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.create(transactionRequest));
    }

}
