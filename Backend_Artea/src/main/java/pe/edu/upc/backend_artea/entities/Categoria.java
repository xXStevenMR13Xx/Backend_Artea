package pe.edu.upc.backend_artea.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="categoria")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria;
    private String nombre_categoria;

    @JsonIgnore
    @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)

    private List<Desafio> desafios;
}
