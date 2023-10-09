package eu.deltasource.training.retailchain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * POJO class used to map the domain model of Country.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryDTO {

    @NotBlank(message = "Country name is required.")
    private String name;
}