package com.lvicentea.store.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalles_ventas")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
    private Double cantidad;
    @Column(name = "precio_unitario")
    private Double precioUnitario;
    private Double subtotal;

}
