package apesteguia.dani.microservicioscursos.controller;

import apesteguia.dani.commonsestudiantes.model.entity.Estudiante;
import apesteguia.dani.commonsmicroservicios.controller.CommonController;
import apesteguia.dani.microservicioscursos.model.entity.Curso;
import apesteguia.dani.microservicioscursos.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public class CursoController extends CommonController<Curso, CursoService> {

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Curso curso, @PathVariable Long id){
        Optional<Curso> o = this.service.findById(id);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Curso cursoDb = o.get();
        cursoDb.setNombre(cursoDb.getNombre());
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoDb));
    }

    @PutMapping("/{id}/asignar-estudiantes")
    public ResponseEntity<?> asignarEstudiantes(@RequestBody List<Estudiante> estudiantes, @PathVariable Long id){
        Optional<Curso> o = this.service.findById(id);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Curso cursoDb = o.get();
        estudiantes.forEach(cursoDb::addEstudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoDb));
    }

    @PutMapping("/{id}/asignar-estudiantes")
    public ResponseEntity<?> asignarEstudiantes(@RequestBody Estudiante estudiante, @PathVariable Long id){
        Optional<Curso> o = this.service.findById(id);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Curso cursoDb = o.get();
        cursoDb.removeEstudiante(estudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoDb));
    }

    @GetMapping("/estudiante/{id}")
    public ResponseEntity<?> buscarEstudiantePorId(@PathVariable Long id){
        return ResponseEntity.ok(this.service.findCursoByEstudianteId(id));
    }



}
