package com.lvicentea.store.dtos.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoResponseDTO {

    public Long id;
    public String nombre;
    public String descripcion;
    public Double precio;
    public Double cantidad;
    public CategoriaResponseDTO categoria;


}
