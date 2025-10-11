package pe.edu.upc.backend_artea.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "progresoDesafio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgresoDesafio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_progresoDesafio;
    private String tipo_progreso;
    private LocalDate fecha_progreso;
    private String estado;
    private String puntuacion;
    private int feedback;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="desafio_id")
    private Desafio desafio;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="calificacion_id")
    private Calificacion calificacion;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="jugador_id")
    private Jugador jugador;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "progresoDesafio_id")
    private Gamificacion gamificacion;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "progresoDesafio_id")
    private List<Creacion> creacions;

}
