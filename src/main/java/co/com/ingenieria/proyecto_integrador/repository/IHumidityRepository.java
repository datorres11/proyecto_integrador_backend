package co.com.ingenieria.proyecto_integrador.repository;

import co.com.ingenieria.proyecto_integrador.entity.Humidity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IHumidityRepository extends MongoRepository<Humidity,Integer > {

    @Query("Select humidity FROM Humidity humidity where humidity.city= :city")
    public List<Humidity> findByCity(String city);

    @Query("Select humidity FROM Humidity humidity where humidity.city= :humidityCode")
    public Optional<Humidity> findByCode(String humidityCode);
}
