package pe.edu.upc.backend_artea.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recompensa")
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "logros")
public class Recompensa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recompen")
    private Integer id;

    private String rangoInsignia;

    @OneToMany(mappedBy = "recompensa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Logro> logros = new ArrayList<>();

}
