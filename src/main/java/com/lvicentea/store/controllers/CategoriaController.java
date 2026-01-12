package com.lvicentea.store.controllers;

import com.lvicentea.store.dtos.request.CategoriaRequestDTO;
import com.lvicentea.store.dtos.response.CategoriaResponseDTO;
import com.lvicentea.store.services.impl.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/id")
    public ResponseEntity<CategoriaResponseDTO> buscarCategoria(@PathVariable Long id){
        CategoriaResponseDTO categoriaResponseDTO = this.categoriaService.buscarCategoriaPorId(id);
        return ResponseEntity.ok().body(categoriaResponseDTO);
    }

    @PutMapping("/id")
    public ResponseEntity<CategoriaResponseDTO> actualizarCategoria(@PathVariable Long id, @RequestBody CategoriaRequestDTO categoriaRequestDTO){
        CategoriaResponseDTO categoriaResponseDTO = this.categoriaService.actualizarCategoria(id, categoriaRequestDTO);
        return ResponseEntity.ok().body(categoriaResponseDTO);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id){
        this.categoriaService.eliminarCategoria(id);
        return ResponseEntity.noContent().build();
    }


}
