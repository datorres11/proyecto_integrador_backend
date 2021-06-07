package co.com.ingenieria.proyecto_integrador.service.impl;

import co.com.ingenieria.proyecto_integrador.dto.HumidityDto;
import co.com.ingenieria.proyecto_integrador.entity.Humidity;
import co.com.ingenieria.proyecto_integrador.repository.IHumidityRepository;
import co.com.ingenieria.proyecto_integrador.service.IHumidityService;
import co.com.ingenieria.proyecto_integrador.utils.GenerarCodigo;
import co.com.ingenieria.proyecto_integrador.utils.HumidityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HumidityServiceImpl implements IHumidityService {

    @Autowired
    IHumidityRepository iHumidityRepository;

    @Override
    public void createHumidity(String humidity, String city) {
        Humidity humidityObject= Humidity.builder().id(iHumidityRepository.findAll().size()+1)
                                                   .city(city).humidity(Float.valueOf(humidity))
                                                   .humidityCode(GenerarCodigo.generarCodigoEntidades()).build();
        iHumidityRepository.save(humidityObject);
    }

    @Override
    public List<HumidityDto> getHumidites() {
        List<HumidityDto> humidityDtos = new ArrayList<>();
        List<Humidity> humidities= iHumidityRepository.findAll();
        for (Humidity humidity:humidities) {
            humidityDtos.add(HumidityDto.builder()
                    .humidity(humidity.getHumidity())
                    .city(humidity.getCity())
                    .humidityCode(humidity.getHumidityCode())
                    .build());
        }
        return humidityDtos;
    }

    @Override
    public List<HumidityDto> getHumiditesByCity(String city) {
        List<HumidityDto> humidityDtos = new ArrayList<>();
        List<Humidity> humidities= iHumidityRepository.findByCity(city);
        for (Humidity humidity:humidities) {
            humidityDtos.add(HumidityDto.builder()
                    .humidity(humidity.getHumidity())
                    .city(humidity.getCity())
                    .humidityCode(humidity.getHumidityCode())
                    .build());
        }
        return humidityDtos;
    }

    @Override
    public void deleteHumidity(String humidityCode) throws Exception {
        Optional<Humidity> humidity = iHumidityRepository.findByHumidityCode(humidityCode);

        if (humidity.isPresent()) {
            iHumidityRepository.delete(humidity.get());
        }else{
            throw new Exception("El dato humedad ha sido eliminado");
        }
    }

    @Override
    public HumidityDto getHumidityPromByCity(String city) {
        float prom=0;
        List<Humidity> humidities= iHumidityRepository.findByCity(city);
        for(Humidity humidity:humidities){
            prom+=humidity.getHumidity();
        }
        prom=prom/humidities.size();
        HumidityDto humidityDto=HumidityDto.builder()
                                .humidity(prom)
                                .city(city)
                                .humidityCode("")
                                .build();
        return humidityDto;
    }
}
