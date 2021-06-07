package co.com.ingenieria.proyecto_integrador.controller;

import co.com.ingenieria.proyecto_integrador.service.ILocationService;
import com.azure.core.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
@CrossOrigin("*")
public class LocationController {

    @Autowired
    ILocationService iLocationService;

    @GetMapping()
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(iLocationService.findAll());
    }
}
