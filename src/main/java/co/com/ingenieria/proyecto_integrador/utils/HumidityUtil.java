package co.com.ingenieria.proyecto_integrador.utils;

import co.com.ingenieria.proyecto_integrador.dto.HumidityDto;
import co.com.ingenieria.proyecto_integrador.entity.Humidity;

public class HumidityUtil {

    public static HumidityDto convertHumidityToHumidityDto(Humidity humidity){
        return HumidityDto.builder()
                .city(humidity.getCity())
                .humidity(humidity.getHumidity())
                .humidityCode(humidity.getHumidityCode())
                .build();
    }
}
