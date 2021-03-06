package com.controledefinancapessoal.controller;

import com.controledefinancapessoal.service.TransferenciaService;
import com.controledefinancapessoal.vo.Transferencia;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api
@RestController


@RequestMapping(path = "/transferencias")
public class TransferenciaController {
    @Autowired
    private TransferenciaService transferenciaService;

    @ApiOperation("Transferencia entre contas")
    @PostMapping
    public ResponseEntity<String> save(@RequestBody @Validated Transferencia transferencia) {
        String statusTransferencia = transferenciaService.fazerTransferencia(transferencia);
        return new ResponseEntity<>(statusTransferencia, HttpStatus.OK);
    }

}

