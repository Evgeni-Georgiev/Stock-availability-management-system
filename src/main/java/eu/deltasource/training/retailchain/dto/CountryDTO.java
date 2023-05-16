package eu.deltasource.training.retailchain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryDTO {

    @NotBlank(message = "Country name is required")
    private String name;
}
