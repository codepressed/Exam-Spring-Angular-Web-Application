package apesteguia.dani.microserviciosusuarios.model.repository;

import apesteguia.dani.commonsestudiantes.model.entity.Estudiante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface EstudianteRepository extends CrudRepository<Estudiante, Long> {



}
