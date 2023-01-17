package apesteguia.dani.microservicioscursos.model.repository;

import apesteguia.dani.microservicioscursos.model.entity.Curso;
import org.springframework.data.repository.CrudRepository;

public interface CursoRepository extends CrudRepository<Curso, Long> {

}
