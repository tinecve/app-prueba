package com.lvicentea.store.controllers;

import com.lvicentea.store.dtos.request.CategoriaRequestDTO;
import com.lvicentea.store.dtos.response.CategoriaResponseDTO;
import com.lvicentea.store.services.impl.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/categories")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> guardarCategoria(@RequestBody CategoriaRequestDTO categoriaRequestDTO){
        CategoriaResponseDTO categoriaResponseDTO = this.categoriaService.guardarCategoria(categoriaRequestDTO);
        return ResponseEntity.created(URI.create("/api/products/" + categoriaResponseDTO.getId())).body(categoriaResponseDTO);
    }
}
