package pe.edu.upc.backend_artea.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "jugador")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jugador")
    private Integer id;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @Column(name = "pais", length = 100, nullable = false)
    private String pais;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Usuario_id_usuar")
    private User usuario;   // FK a User
}
