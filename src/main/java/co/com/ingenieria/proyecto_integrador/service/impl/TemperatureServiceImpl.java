package co.com.ingenieria.proyecto_integrador.service.impl;

import co.com.ingenieria.proyecto_integrador.dto.TemperatureDto;
import co.com.ingenieria.proyecto_integrador.entity.Temperature;
import co.com.ingenieria.proyecto_integrador.repository.ITemperatureRepository;
import co.com.ingenieria.proyecto_integrador.service.ITemperatureService;
import co.com.ingenieria.proyecto_integrador.utils.GenerarCodigo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TemperatureServiceImpl implements ITemperatureService {

    @Autowired
    ITemperatureRepository iTemperatureRepository;

    @Override
    public void createTemperatures(String temperature, String city) {
        Temperature temperatureObject = Temperature.builder().id(iTemperatureRepository.findAll().size()+1).temperature(Float.valueOf(temperature))
                                                             .temperatureCode(GenerarCodigo.generarCodigoEntidades())
                                                             .city(city).build();
        iTemperatureRepository.save(temperatureObject);
    }

    @Override
    public List<TemperatureDto> getTemperatures() {
        List<TemperatureDto> temperatureDtos = new ArrayList<>();
        List<Temperature> temperatures= iTemperatureRepository.findAll();
        for (Temperature temperature:temperatures) {
            temperatureDtos.add(TemperatureDto.builder()
                                              .temperature(temperature.getTemperature())
                                              .city(temperature.getCity())
                                              .temperatureCode(temperature.getTemperatureCode())
                                              .build());
        }
        return temperatureDtos;
    }

    @Override
    public List<TemperatureDto> getTemperaturesByCity(String city) {
        List<TemperatureDto> temperatureDtos = new ArrayList<>();
        List<Temperature> temperatures= iTemperatureRepository.findByCity(city);
        for (Temperature temperature:temperatures) {
            temperatureDtos.add(TemperatureDto.builder()
                                              .temperature(temperature.getTemperature())
                                              .city(temperature.getCity())
                                              .temperatureCode(temperature.getTemperatureCode())
                                              .build());
        }
        return temperatureDtos;
    }

    @Override
    public void deleteTemperature(String temperatureCode) throws Exception {
        Optional<Temperature> temperature = iTemperatureRepository.findByTemperatureCode(temperatureCode);

        if (temperature.isPresent()) {
            iTemperatureRepository.delete(temperature.get());
        }else{
            throw new Exception("El dato temperatura ha sido eliminado");
        }
    }

    @Override
    public TemperatureDto getTemperaturePromByCity(String city) {
        float prom=0;
        List<Temperature> temperatures= iTemperatureRepository.findByCity(city);
        for(Temperature temperature:temperatures){
            prom+=temperature.getTemperature();
        }
        prom=prom/temperatures.size();
        TemperatureDto temperatureDto=TemperatureDto.builder()
                .temperature(prom)
                .city(city)
                .temperatureCode("")
                .build();

        return temperatureDto;
    }
}
