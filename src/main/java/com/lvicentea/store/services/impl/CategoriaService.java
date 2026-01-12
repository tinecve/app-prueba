package com.lvicentea.store.services.impl;

import com.lvicentea.store.dtos.request.CategoriaRequestDTO;
import com.lvicentea.store.dtos.response.CategoriaResponseDTO;
import com.lvicentea.store.entities.Categoria;
import com.lvicentea.store.exception.NotFoundException;
import com.lvicentea.store.exception.ResourceAlreadyExistsException;
import com.lvicentea.store.repositories.CategoriaRepository;
import com.lvicentea.store.services.ICategoriaService;
import com.lvicentea.store.utils.MapperCategoria;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService implements ICategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public CategoriaResponseDTO guardarCategoria(CategoriaRequestDTO categoriaRequestDTO) {
        Categoria categoria = MapperCategoria.categoriaRequestTOCategoria(categoriaRequestDTO);
        if(categoria.getId() != null) {
            Optional<Categoria> categoriaOptional = this.categoriaRepository.findById(categoria.getId());
            if(categoriaOptional.isPresent()) {
                throw new ResourceAlreadyExistsException("Categoria ya existe!");
            }
        }
        categoria = this.categoriaRepository.save(categoria);
        return MapperCategoria.categoriaToCategoriaResponse(categoria);
    }

    @Override
    public CategoriaResponseDTO buscarCategoriaPorId(Long id) {
        Optional<Categoria> categoria = this.categoriaRepository.findById(id);
        if(categoria.isPresent()){
            return MapperCategoria.categoriaToCategoriaResponse(categoria.get());
        }else{
            throw new NotFoundException("Categoria no encontrada");
        }
    }

    @Override
    public CategoriaResponseDTO actualizarCategoria(Long id, CategoriaRequestDTO categoriaRequestDTO) {
        Optional<Categoria> categoria = this.categoriaRepository.findById(id);
        if(categoria.isPresent()) {
            Categoria categoria1 = categoria.get();
            categoria1.setNombre(categoriaRequestDTO.getNombre());
            categoria1.setDescripcion(categoriaRequestDTO.getDescripcion());
            return MapperCategoria.categoriaToCategoriaResponse(this.categoriaRepository.save(categoria1));
        }else{
            throw new NotFoundException("Categoria no existe");
        }
    }

    @Override
    public void eliminarCategoria(Long id) {
        Optional<Categoria> categoria = this.categoriaRepository.findById(id);
        if(categoria.isPresent()) {
            this.categoriaRepository.deleteById(id);
        }else{
            throw new NotFoundException("Categoria no encontrada");
        }
    }
}
