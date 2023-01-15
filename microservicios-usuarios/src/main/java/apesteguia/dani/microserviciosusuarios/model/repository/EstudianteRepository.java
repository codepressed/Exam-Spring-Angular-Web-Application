package apesteguia.dani.microserviciosusuarios.model.repository;

import apesteguia.dani.microserviciosusuarios.model.entity.Estudiante;
import apesteguia.dani.microserviciosusuarios.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface EstudianteRepository extends CrudRepository<Estudiante, Long> {



}
