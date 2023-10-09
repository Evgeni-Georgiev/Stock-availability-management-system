package eu.eugene.training.retailchain.dto.supplier;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * POJO class used to map the domain models of Supplier, Contact and Address.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDetailsDTO {

    private int id;

    @NotNull
    @Size(min = 4, max = 10, message = "Name must be between 4 and 10 characters.")
    private String name;

    @NotNull
    @Pattern(regexp = "^\\d{8}$", message = "idNumber must be 8 characters.")
    private String idNumber;

    @Email(message = "Invalid email.")
    private String email;

    @NotBlank(message = "Country name is required.")
    private String countryName;
}