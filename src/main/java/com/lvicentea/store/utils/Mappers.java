package com.lvicentea.store.utils;

import com.lvicentea.store.dtos.request.ProductoRequestDTO;
import com.lvicentea.store.dtos.response.ProductoResponseDTO;
import com.lvicentea.store.entities.Producto;
import org.springframework.stereotype.Component;

@Component
public class Mappers {

    public static final ProductoResponseDTO productoToProductoResponseDTO(Producto producto){
        ProductoResponseDTO productoResponseDTO = new ProductoResponseDTO();

        productoResponseDTO.setId(producto.getId());
        productoResponseDTO.setNombre(producto.getNombre());
        productoResponseDTO.setDescripcion(producto.getDescripcion());
        productoResponseDTO.setCantidad(producto.getCantidad());
        productoResponseDTO.setPrecio(producto.getPrecio());

        return productoResponseDTO;
    }

    public static final Producto productoRequestToProducto(ProductoRequestDTO productoRequestDTO){
        Producto producto = new Producto();

        producto.setNombre(productoRequestDTO.getNombre());
        producto.setDescripcion(productoRequestDTO.getDescripcion());
        producto.setCantidad(productoRequestDTO.getCantidad());
        producto.setPrecio(productoRequestDTO.getPrecio());

        return producto;
    }

}
