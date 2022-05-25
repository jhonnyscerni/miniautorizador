package br.com.vr.miniautorizador.api.v1.openapi;

import br.com.vr.miniautorizador.api.v1.request.CardRequest;
import br.com.vr.miniautorizador.api.v1.response.AmountResponse;
import br.com.vr.miniautorizador.api.v1.response.CardResponse;
import br.com.vr.miniautorizador.exceptionhandler.Problem;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Card", description = "Endpoint de Cartões VR")
public interface CardOpenApi {

    @Operation(description = "Busca um cartão por ID", summary = "Busca um Cartão por ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Busca Realizada com Sucesso"),
        @ApiResponse(responseCode = "404", description = "Cartão não encontrado", content = @Content(schema = @Schema(implementation = Problem.class)))
    })
    ResponseEntity<AmountResponse> findById(@PathVariable String numberCard);

    @Operation(description = "Cadastra um cliente", summary = "Cadastra um cliente")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Cliente cadastrado"),
        @ApiResponse(responseCode = "422", description = "Cartão já existe", content = @Content(schema = @Schema(implementation = Problem.class))),
        @ApiResponse(responseCode = "400", description = "Validação de Dados", content = @Content(schema = @Schema(implementation = Problem.class))),
    })
    ResponseEntity<CardResponse> create(@RequestBody @Valid CardRequest cardRequest);

}
