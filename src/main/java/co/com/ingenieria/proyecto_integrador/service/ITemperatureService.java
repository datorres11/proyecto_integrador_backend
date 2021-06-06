package co.com.ingenieria.proyecto_integrador.service;

import co.com.ingenieria.proyecto_integrador.dto.TemperatureDto;
import co.com.ingenieria.proyecto_integrador.entity.Temperature;

import java.util.List;

public interface ITemperatureService {

    public void createTemperatures(String temperature, String city);

    public List<TemperatureDto> getTemperatures();

    public List<TemperatureDto> getTemperaturesByCity(String city);

    public void deleteTemperature(String temperatureCode) throws Exception;
}
