package apesteguia.dani.microserviciosusuarios.controller;

import apesteguia.dani.commonsestudiantes.model.entity.Estudiante;
import apesteguia.dani.commonsmicroservicios.controller.CommonController;
import apesteguia.dani.microserviciosusuarios.service.EstudianteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EstudianteController extends CommonController<Estudiante, EstudianteService> {

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Estudiante estudiante, @PathVariable Long id){
        Optional<Estudiante> est = service.findById(id);
        if(est.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Estudiante estudianteDb = est.get();
        estudianteDb.setNombre(estudiante.getNombre());
        estudianteDb.setApellido(estudiante.getApellido());
        estudianteDb.setEmail(estudiante.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(estudianteDb));
    }




}
