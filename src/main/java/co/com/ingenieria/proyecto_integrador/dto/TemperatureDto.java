package co.com.ingenieria.proyecto_integrador.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TemperatureDto {

    private Float temperature;
    private String city;
    private String temperatureCode;
}
