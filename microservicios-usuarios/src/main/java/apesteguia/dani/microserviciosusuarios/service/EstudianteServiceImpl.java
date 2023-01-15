package apesteguia.dani.microserviciosusuarios.service;

import apesteguia.dani.commonsmicroservicios.service.CommonServiceImpl;
import apesteguia.dani.microserviciosusuarios.model.entity.Estudiante;
import apesteguia.dani.microserviciosusuarios.model.repository.EstudianteRepository;
import org.springframework.stereotype.Service;


@Service
public class EstudianteServiceImpl extends CommonServiceImpl<Estudiante, EstudianteRepository> implements EstudianteService{

}
