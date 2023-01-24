package apesteguia.dani.microservicioscursos.service;

import apesteguia.dani.commonsestudiantes.model.entity.Estudiante;
import apesteguia.dani.commonsmicroservicios.service.CommonServiceImpl;
import apesteguia.dani.microservicioscursos.model.entity.Curso;
import apesteguia.dani.microservicioscursos.model.repository.CursoRepository;
import org.springframework.transaction.annotation.Transactional;

public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService{

    @Override
    @Transactional(readOnly = true)
    public Curso findCursoByEstudianteId(Long id) {
        return repository.findCursoByEstudianteId(id);
    }
}
