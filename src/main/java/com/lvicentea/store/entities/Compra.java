package com.lvicentea.store.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fecha_compra", nullable = false)
    private LocalDateTime fechaCompra;
    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;
    private Double total;
    private String estado;
    private String observaciones;

    @OneToMany(mappedBy = "compra", fetch = FetchType.LAZY)
    private List<DetalleCompra> detalleCompra;

}
