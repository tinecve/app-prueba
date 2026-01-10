package com.lvicentea.store.services;

import com.lvicentea.store.dtos.request.CategoriaRequestDTO;
import com.lvicentea.store.dtos.response.CategoriaResponseDTO;

public interface ICategoriaService {

    public CategoriaResponseDTO guardarCategoria(CategoriaRequestDTO categoriaRequestDTO);

    public CategoriaResponseDTO buscarCategoriaPorId(Long id);

    public CategoriaResponseDTO actualizarCategoria(Long id, CategoriaRequestDTO categoriaRequestDTO);

    public void eliminarCategoria(Long id);

}
