package co.com.ingenieria.proyecto_integrador.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Builder
@Data
@Document(collection="Humidity")
@NoArgsConstructor
@AllArgsConstructor
public class Humidity {

    @Id
    @NotNull
    private Integer id;

    private Float humidity;

    private String city;

    private String humidityCode;
}
