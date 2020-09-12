package ar.com.noaa.mongo.api.controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.noaa.mongo.api.entities.Muestra;
import ar.com.noaa.mongo.api.models.request.MuestraRequest;
import ar.com.noaa.mongo.api.models.response.MuestraResponse;
import ar.com.noaa.mongo.api.service.BoyaService;

@RestController
public class MuestraController {


    @Autowired
    BoyaService bService;

    @PostMapping("/muestras")
    public ResponseEntity<MuestraResponse> registrarMuestra(@RequestBody MuestraRequest mR) {
        Muestra muestra = bService.crearMuestra(new ObjectId(mR.boyaId), mR.alturaNivelMar, mR.horario, mR.latitud, mR.longitud,
                mR.matricula);
        if (muestra == null) {
            return ResponseEntity.badRequest().build();
        }
        MuestraResponse mResp = new MuestraResponse();
        mResp.color = "Verde";
        return ResponseEntity.ok(mResp);
    }
}