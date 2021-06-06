package co.com.ingenieria.proyecto_integrador.repository;

import co.com.ingenieria.proyecto_integrador.entity.Temperature;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ITemperatureRepository extends MongoRepository<Temperature,Integer> {

    public List<Temperature> findByCity(String city);

    public Optional<Temperature> findByTemperatureCode(String temperatureCode);

}
