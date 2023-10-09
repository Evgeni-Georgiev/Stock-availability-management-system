package eu.eugene.training.retailchain.dto.supplier;

import eu.eugene.training.retailchain.dto.ContactDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * POJO class used to map the domain model of Supplier.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDTO {

    private int id;

    @NotNull
    @Size(min = 4, max = 255, message = "Name must be between 4 and 255 characters.")
    private String name;

    @NotNull
    @Pattern(regexp = "^\\d{8}$", message = "idNumber must be 8 characters.")
    private String idNumber;

    @Valid
    private ContactDTO contactDTO;
}