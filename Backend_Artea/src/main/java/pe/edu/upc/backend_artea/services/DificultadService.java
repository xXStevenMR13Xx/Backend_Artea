package pe.edu.upc.backend_artea.services;

import pe.edu.upc.backend_artea.dtos.DificultadCreateUpdateDTO;
import pe.edu.upc.backend_artea.dtos.DificultadDTO;

import java.util.List;

public interface DificultadService {
    DificultadDTO create(DificultadCreateUpdateDTO dto);
    DificultadDTO update(Integer id, DificultadCreateUpdateDTO dto);
    void delete(Integer id);
    DificultadDTO getById(Integer id);
    List<DificultadDTO> listAll();
    List<DificultadDTO> searchByTipo(String q);
}
