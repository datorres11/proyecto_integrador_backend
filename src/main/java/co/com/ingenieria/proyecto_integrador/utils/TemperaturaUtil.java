package co.com.ingenieria.proyecto_integrador.utils;

import co.com.ingenieria.proyecto_integrador.dto.TemperatureDto;
import co.com.ingenieria.proyecto_integrador.entity.Temperature;

public class TemperaturaUtil {
    public static TemperatureDto convertTemperatureToTemperatureDto(Temperature temperature){
        return TemperatureDto.builder()
                             .city(temperature.getCity())
                             .temperature(temperature.getTemperature())
                             .temperatureCode(temperature.getTemperatureCode())
                             .build();
    }
}
