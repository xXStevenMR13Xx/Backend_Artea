package pe.edu.upc.backend_artea.services;

import pe.edu.upc.backend_artea.dtos.CreacionCreateUpdateDTO;
import pe.edu.upc.backend_artea.dtos.CreacionDTO;

import java.util.List;

public interface CreacionService {
    CreacionDTO create(CreacionCreateUpdateDTO dto);
    CreacionDTO update(Integer id, CreacionCreateUpdateDTO dto);
    void delete(Integer id);
    CreacionDTO getById(Integer id);
    List<CreacionDTO> listAll();
    List<CreacionDTO> searchByTitulo(String q);
}
