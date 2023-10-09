package eu.deltasource.training.retailchain.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * POJO class used to map the domain model of Address.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    @NotBlank(message = "Address line is required.")
    private String addressLine;

    @NotBlank(message = "City is required.")
    private String city;

    @NotNull
    @Size(min = 4, max = 10, message = "Postal code must be between 4 and 10 characters.")
    private String postalCode;

    @Valid
    private CountryDTO country;
}
