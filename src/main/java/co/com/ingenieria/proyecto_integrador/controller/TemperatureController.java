package co.com.ingenieria.proyecto_integrador.controller;

import co.com.ingenieria.proyecto_integrador.service.ITemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/temperature")
@CrossOrigin("*")
public class TemperatureController {

    @Autowired
    ITemperatureService iTemperatureService;

    @GetMapping()
    public ResponseEntity<?> getTemperatures() {
        return ResponseEntity.ok(iTemperatureService.getTemperatures());
    }

    @GetMapping("/{city}")
    public ResponseEntity<?> getTemperaturesByCity(@PathVariable String city) {
        return ResponseEntity.ok(iTemperatureService.getTemperaturesByCity(city));

    }

    @GetMapping("/prom/{city}")
    public ResponseEntity<?> getTemperaturePromByCity(@PathVariable String city) {
        return ResponseEntity.ok(iTemperatureService.getTemperaturePromByCity(city));

    }

    @DeleteMapping("/{TemeperatureCode}")
    public ResponseEntity<?> deleteHumidity(@PathVariable String humidityCode) {
        try{
            iTemperatureService.deleteTemperature(humidityCode);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getCause(),HttpStatus.CONFLICT);
        }
    }
}
