package com.lvicentea.store.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoRequestDTO {

    @NotBlank
    @NotNull
    public String nombre;
    public String descripcion;
    @NotBlank
    @NotNull
    public Double precio;
    @NotBlank
    @NotNull
    public Double cantidad;

}
