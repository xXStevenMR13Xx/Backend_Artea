package pe.edu.upc.backend_artea.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="desafios")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Desafio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_desafio;

    private String nombre_desafio;
    private String tipo_desafio;
    private String instruccion;
    private Integer max_intentos;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="categoria_id")
    private Categoria categoria;

}
