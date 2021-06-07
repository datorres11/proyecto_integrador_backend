package co.com.ingenieria.proyecto_integrador.service.impl;

import co.com.ingenieria.proyecto_integrador.dto.LocationDto;
import co.com.ingenieria.proyecto_integrador.entity.Location;
import co.com.ingenieria.proyecto_integrador.repository.ILocationRepository;
import co.com.ingenieria.proyecto_integrador.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements ILocationService {

    @Autowired
    ILocationRepository iLocationRepository;

    @Override
    public List<LocationDto> findAll() {
        List<LocationDto> locationDtos = new ArrayList<>();
        List<Location> locations= iLocationRepository.findAll();
        for (Location location:locations) {
            locationDtos.add(LocationDto.builder()
                        .city(location.getCity())
                        .country(location.getCountry())
                        .cityCode(location.getCityCode())
                        .build());
        }
        locationDtos = locationDtos.stream().filter(distinctByKey(p->p.getCity())).collect(Collectors.toList());
        return locationDtos;
    }

    private <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    @Override
    public void createLocation(String city, String country, String cityCode) {
        Optional<Location> locationEntity=iLocationRepository.findByCity(city);
        if(!locationEntity.isPresent()) {
            Location location = Location.builder().id(iLocationRepository.findAll().size() + 1)
                    .city(city)
                    .country(country)
                    .cityCode(cityCode)
                    .build();
            iLocationRepository.save(location);
        }
    }

    @Override
    public void deleteLocation(String cityCode) {
        Optional<Location> location=iLocationRepository.findByCityCode(cityCode);
        if(location.isPresent()){
            iLocationRepository.delete(location.get());
        }
    }
}
