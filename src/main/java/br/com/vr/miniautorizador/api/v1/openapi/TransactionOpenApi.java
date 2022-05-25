package br.com.vr.miniautorizador.api.v1.openapi;

import br.com.vr.miniautorizador.api.v1.request.TransactionRequest;
import br.com.vr.miniautorizador.exceptionhandler.Problem;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Transaction", description = "Endpoint de Transações VR")
public interface TransactionOpenApi {

    @Operation(description = "Cadastra uma Transação", summary = "Cadastra uma Transação")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Transação cadastrada"),
        @ApiResponse(responseCode = "400", description = "Validação de Dados", content = @Content(schema = @Schema(implementation = Problem.class))),
    })
    ResponseEntity<?> create(@RequestBody @Valid TransactionRequest transactionRequest);

}
