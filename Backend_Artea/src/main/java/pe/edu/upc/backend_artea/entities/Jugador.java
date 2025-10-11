package pe.edu.upc.backend_artea.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Usuario_id_usuar", nullable = false)
    private User usuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Nivel_id_nivel", nullable = false)
    private Nivel nivel;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "jugador_id")
    private List<Logro> logros;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "jugador_id")
    private List<ProgresoDesafio> progresoDesafios;

}
