package ar.com.noaa.mongo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.noaa.mongo.api.entities.Boya;
import ar.com.noaa.mongo.api.models.request.BoyaRequest;
import ar.com.noaa.mongo.api.models.response.GenericResponse;
import ar.com.noaa.mongo.api.service.BoyaService;

@RestController
public class BoyaController {
    
    @Autowired
    BoyaService bS;

    @PostMapping("/boyas")
    public ResponseEntity<GenericResponse> crearBoya(@RequestBody BoyaRequest bR) {
        Boya boya = new Boya();
        boya.setLongitudInstalacion(bR.longitudInstalacion);
        boya.setLatitudInstalacion(bR.latitudInstalacion);
        bS.crearBoya(boya);
        GenericResponse gR = new GenericResponse();
        gR.isOk = true;
        gR.id = boya.get_id(); //.toHexString();
        gR.mensaje = "Boya creada con exito";
        return ResponseEntity.ok(gR);
    }

    @GetMapping("/boyas")
    public ResponseEntity<List<Boya>> listarBoyas() {
        return ResponseEntity.ok(bS.obtenerBoyas());
    }
}
