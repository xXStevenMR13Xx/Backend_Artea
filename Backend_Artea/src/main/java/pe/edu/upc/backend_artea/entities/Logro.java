package pe.edu.upc.backend_artea.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "logro")
@NoArgsConstructor
@AllArgsConstructor
public class Logro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_logro")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "jugador_id_jugador", nullable = false)
    private Jugador jugador;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Recompensa_id_recompen", nullable = false)
    private Recompensa recompensa;
}
