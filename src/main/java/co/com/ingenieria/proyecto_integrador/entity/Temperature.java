package co.com.ingenieria.proyecto_integrador.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

@Builder
@Data
@Document(collection="Temperature")
@NoArgsConstructor
@AllArgsConstructor
public class Temperature {
    @Id
    @NotNull
    private Integer id;

    private Float temperature;

    private String city;

    private String temperatureCode;
}
