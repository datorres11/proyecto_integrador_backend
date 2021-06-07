package co.com.ingenieria.proyecto_integrador.service;

import co.com.ingenieria.proyecto_integrador.dto.LocationDto;

import java.util.List;

public interface ILocationService {

    public List<LocationDto> findAll();

    public void createLocation(String city, String country, String cityCode);

    public void deleteLocation(String cityCode);
}
