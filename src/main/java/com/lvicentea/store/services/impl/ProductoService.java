package com.lvicentea.store.services.impl;

import com.lvicentea.store.dtos.request.ProductoRequestDTO;
import com.lvicentea.store.dtos.response.ProductoResponseDTO;
import com.lvicentea.store.entities.Producto;
import com.lvicentea.store.exception.NotFoundException;
import com.lvicentea.store.repositories.ProductoRepository;
import com.lvicentea.store.services.IProductoService;
import com.lvicentea.store.utils.Mappers;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public ProductoResponseDTO findProducto(Long id) {
        Optional<Producto> producto = this.productoRepository.findById(id);
        if (producto.isPresent()) {
            return Mappers.productoToProductoResponseDTO(producto.get());
        }else {
            throw new NotFoundException("Producto no encontrado");
        }
    }

    @Override
    public ProductoResponseDTO updateProducto(Long id, ProductoRequestDTO productoRequestDTO) {
        Optional<Producto> productoOpt = this.productoRepository.findById(id);
        if (productoOpt.isPresent()) {
            Producto producto = productoOpt.get();
            producto.setNombre(productoRequestDTO.getNombre());
            producto.setDescripcion(productoRequestDTO.getDescripcion());
            producto.setPrecioCompra(productoRequestDTO.getPrecio());
            producto.setStockActual(productoRequestDTO.getCantidad());
            return Mappers.productoToProductoResponseDTO(this.productoRepository.save(producto));
        }else{
            throw new NotFoundException("Producto no encontrado para modificar");
        }
    }

    @Override
    public void deleteProduct(Long id) {
        Optional<Producto> producto = this.productoRepository.findById(id);
        if(producto.isPresent()){
            this.productoRepository.deleteById(id);
        }else{
            throw new NotFoundException("Producto no encontrado para eliminar");
        }
    }
}
