package com.lvicentea.store.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalle_compras")
public class DetalleCompra {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "compra_id")
    private Compra compra;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
    @Column(name = "unidad_medida")
    private String unidadMedida;
    private Double cantidad;
    @Column(name = "precio_unitario")
    private Double precioUnitario;
    private Double subtotal;
}
