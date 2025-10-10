package pe.edu.upc.backend_artea.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "creacion")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Creacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_creaci")
    private Integer id;

    @Column(name = "titulo", length = 500, nullable = false)
    private String titulo;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "imagen")
    private byte[] imagen;   // se enviará/recibirá como Base64 en el DTO

    @Column(name = "formato", length = 500)
    private String formato;
}
