package com.lvicentea.store.utils;

import com.lvicentea.store.dtos.request.CategoriaRequestDTO;
import com.lvicentea.store.dtos.response.CategoriaResponseDTO;
import com.lvicentea.store.entities.Categoria;
import org.springframework.stereotype.Component;

@Component
public class MapperCategoria {

    public static final Categoria categoriaRequestTOCategoria(CategoriaRequestDTO categoriaRequestDTO){
        Categoria categoria = new Categoria();
        categoria.setId(categoriaRequestDTO.getId());
        categoria.setNombre(categoriaRequestDTO.getNombre());
        categoria.setDescripcion(categoriaRequestDTO.getDescripcion());
        return categoria;
    }

    public static final CategoriaResponseDTO categoriaToCategoriaResponse(Categoria categoria){
        CategoriaResponseDTO categoriaResponseDTO = new CategoriaResponseDTO();
        categoriaResponseDTO.setId(categoria.getId());
        categoriaResponseDTO.setNombre(categoria.getNombre());
        categoriaResponseDTO.setDescripcion(categoria.getDescripcion());
        return categoriaResponseDTO;
    }

}
