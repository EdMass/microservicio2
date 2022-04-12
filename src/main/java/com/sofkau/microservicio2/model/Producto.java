package com.sofkau.microservicio2.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productos")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Getter
@Setter
@EqualsAndHashCode
public class Producto {

    @Id
    private String id;
    @NonNull private String nombre;
    @NonNull private Double precio;
    private Integer stock;
    private String descripcion;
}
