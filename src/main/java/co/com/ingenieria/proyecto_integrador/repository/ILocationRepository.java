package co.com.ingenieria.proyecto_integrador.repository;

import co.com.ingenieria.proyecto_integrador.entity.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ILocationRepository extends MongoRepository<Location,Integer> {

    public Optional<Location> findByCityCode(String city);

    public Optional<Location> findByCity(String city);
}
