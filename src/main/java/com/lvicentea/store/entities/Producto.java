package com.lvicentea.store.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String nombre;
    private String descripcion;
    @Column(name = "precio_compra", nullable = false)
    private Double precioCompra;
    @Column(name = "precio_venta", nullable = false)
    private Double precioVenta;
    @Column(name = "stock_actual", nullable = false)
    private Double stockActual;
    @Column(name = "stock_minimo", nullable = false)
    private Double stockMinimo;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;
    private boolean activo;

    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
    private List<DetalleCompra> detalleCompras;

    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
    private List<DetalleVenta> detalleVentas;

}
