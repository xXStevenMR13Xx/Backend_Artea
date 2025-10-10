package pe.edu.upc.backend_artea.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "nivel")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Nivel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_nivel;

    @Column(length = 100, nullable = false)
    private String nombre_niv;

    // Un nivel puede tener muchos jugadores
    @JsonIgnore
    @OneToMany(mappedBy = "nivel")
    private List<Jugador> jugadores;
}

