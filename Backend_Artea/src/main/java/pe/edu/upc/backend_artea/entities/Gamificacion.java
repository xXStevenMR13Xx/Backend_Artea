package pe.edu.upc.backend_artea.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "gamificacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gamificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_gamificacion;

    private Integer racha_dias;

    @Column(length = 1000)
    private String notificacion;

    @JsonIgnore
    @OneToMany(mappedBy = "gamificacion")
    private List<ProgresoDesafio> progresos;
}
