package pe.edu.upc.backend_artea.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dificultad")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Dificultad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dificultad")
    private Integer id;

    @Column(name = "tipo_dificultad", length = 100, nullable = false, unique = true)
    private String tipo;
}
