package co.com.ingenieria.proyecto_integrador.controller;

import co.com.ingenieria.proyecto_integrador.service.IHumidityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/humidity")
@CrossOrigin("*")
public class HumidityController {

    @Autowired
    IHumidityService iHumidityService;

    @GetMapping()
    public ResponseEntity<?> getHumidities() {
        return ResponseEntity.ok(iHumidityService.getHumidites());
    }

    @GetMapping("/{city}")
    public ResponseEntity<?> getHumiditiesByCity(@PathVariable String city) {
        return ResponseEntity.ok(iHumidityService.getHumiditesByCity(city));
    }
    @GetMapping("/prom/{city}")
    public ResponseEntity<?> gethumidityPromByCity(@PathVariable String city) {
        return ResponseEntity.ok(iHumidityService.getHumidityPromByCity(city));
    }

    @DeleteMapping("/{humidityCode}")
    public ResponseEntity<?> deleteHumidity(@PathVariable String humidityCode) {
        try{
            iHumidityService.deleteHumidity(humidityCode);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getCause(),HttpStatus.CONFLICT);
        }
    }
}
