package com.lvicentea.store.controllers;

import com.lvicentea.store.dtos.request.ProductoRequestDTO;
import com.lvicentea.store.dtos.response.ProductoResponseDTO;
import com.lvicentea.store.services.IProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/products")
public class ProductoController {

    private final IProductoService productoService;

    public ProductoController(IProductoService productoService){
        this.productoService = productoService;
    }

    @PostMapping()
    public ResponseEntity<ProductoResponseDTO> guardar(@RequestBody ProductoRequestDTO productoRequestDTO){
        ProductoResponseDTO creado = this.productoService.saveProducto(productoRequestDTO);
        return ResponseEntity.created(URI.create("/api/products/"+creado.getId())).body(creado);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> buscarPorId(@PathVariable Long id){
        ProductoResponseDTO productoResponseDTO = this.productoService.findProducto(id);
        return ResponseEntity.ok().body(productoResponseDTO);
    }

}
