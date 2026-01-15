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
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fecha_venta")
    private LocalDateTime fechaVenta;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @Column(name = "tipo_pago")
    private String tipoPago;
    private Double total;
    private Double pagado;
    private Double cambio;
    private String estado;
    private String observaciones;
    @OneToMany(mappedBy = "venta", fetch = FetchType.LAZY)
    private List<DetalleVenta> detalleVenta;

}
