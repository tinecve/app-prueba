package com.lvicentea.store.services;

import com.lvicentea.store.dtos.request.ProductoRequestDTO;
import com.lvicentea.store.dtos.response.ProductoResponseDTO;

public interface IProductoService {

    public ProductoResponseDTO saveProducto(ProductoRequestDTO productoRequestDTO);

    public ProductoResponseDTO findProducto(Long id);


}
