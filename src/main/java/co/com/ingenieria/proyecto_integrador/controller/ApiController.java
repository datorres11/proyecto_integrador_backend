package co.com.ingenieria.proyecto_integrador.controller;

import co.com.ingenieria.proyecto_integrador.service.IApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    IApiService iApiService;

    @PostMapping("/data/{city}")
    public ResponseEntity<?> getApiData(@PathVariable String city) {
        try{
            iApiService.getHumidityAndTemperatureApi(city);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getCause(),HttpStatus.BAD_REQUEST);
        }
    }
}
