package com.lvicentea.store.services.impl;

import com.lvicentea.store.dtos.request.ProductoRequestDTO;
import com.lvicentea.store.dtos.response.ProductoResponseDTO;
import com.lvicentea.store.entities.Producto;
import com.lvicentea.store.repositories.ProductoRepository;
import com.lvicentea.store.services.IProductoService;
import com.lvicentea.store.utils.Mappers;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public ProductoResponseDTO saveProducto(ProductoRequestDTO productoRequestDTO) {
        Producto producto = Mappers.productoRequestToProducto(productoRequestDTO);
        return Mappers.productoToProductoResponseDTO(this.productoRepository.save(producto));
    }
}
