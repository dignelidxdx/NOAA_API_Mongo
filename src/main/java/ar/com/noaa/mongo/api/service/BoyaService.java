package ar.com.noaa.mongo.api.service;

import java.sql.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.noaa.mongo.api.entities.Boya;
import ar.com.noaa.mongo.api.entities.Muestra;
import ar.com.noaa.mongo.api.repos.BoyaRepository;

@Service
public class BoyaService {
    
    @Autowired
    BoyaRepository boyaRepo;
   
    public void crearBoya(Boya boya) {
        grabar(boya);
    }

    public void grabar(Boya boya) {
        boyaRepo.save(boya);
    }

    public List<Boya> obtenerBoyas() {
        return boyaRepo.findAll();
    }

    public Boya obtenerPorId(ObjectId boyaId) {
        return boyaRepo.findBy_id(boyaId);
    }

    public Muestra crearMuestra(ObjectId boyaId, Double alturaNivelMar, Date horario, Double latitud, Double longitud,
            String matricula) {

        Muestra muestra = new Muestra();
        Boya boya = obtenerPorId(boyaId);
        muestra.setAlturaNivelDelMar(alturaNivelMar);
        muestra.setHorarioMuestra(horario);
        muestra.setLatitud(latitud);
        muestra.setLongitud(longitud);
        muestra.setMatriculaEmbarcacion(matricula);
        boya.getMuestras().add(muestra);
        grabar(boya);
        return muestra;
        
    }
}
