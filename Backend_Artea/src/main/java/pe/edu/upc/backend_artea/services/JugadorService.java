package pe.edu.upc.backend_artea.services;

import pe.edu.upc.backend_artea.dtos.JugadorCreateUpdateDTO;
import pe.edu.upc.backend_artea.dtos.JugadorDTO;

import java.util.List;

public interface JugadorService {
    JugadorDTO create(JugadorCreateUpdateDTO dto);
    JugadorDTO update(Integer id, JugadorCreateUpdateDTO dto);
    void delete(Integer id);
    JugadorDTO getById(Integer id);
    JugadorDTO getByUserId(Integer userId);
    List<JugadorDTO> listAll();
    List<JugadorDTO> searchByPais(String q);
}

