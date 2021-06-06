package co.com.ingenieria.proyecto_integrador.service;

import co.com.ingenieria.proyecto_integrador.dto.HumidityDto;
import co.com.ingenieria.proyecto_integrador.entity.Humidity;

import java.util.List;

public interface IHumidityService {

    public void createHumidity(String humidity, String city);

    public List<HumidityDto> getHumidites();

    public List<HumidityDto> getHumiditesByCity(String city);

    public void deleteHumidity(String humidityCode) throws Exception;


}
