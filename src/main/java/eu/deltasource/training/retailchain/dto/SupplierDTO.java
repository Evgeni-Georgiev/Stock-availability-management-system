package eu.deltasource.training.retailchain.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDTO {

    @NotNull
    @Size(min = 4, max = 255, message = "Name must be between 4 and 255 characters.")
    private String name;

    @NotNull
    @Pattern(regexp = "^\\d{8}$", message = "idNumber must be 8 characters.")
    private String idNumber;

    private ContactDTO contactDTO;
}
