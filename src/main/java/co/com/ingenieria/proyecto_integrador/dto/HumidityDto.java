package co.com.ingenieria.proyecto_integrador.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HumidityDto {

    private Float humidity;
    private String city;
    private String humidityCode;

}
