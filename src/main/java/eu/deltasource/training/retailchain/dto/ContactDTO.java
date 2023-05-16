package eu.deltasource.training.retailchain.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {

    @NotNull
    @Size(min = 4, max = 255, message = "Name must be between 4 and 255 characters.")
    private String name;

    @Email(message = "Invalid email.")
    private String email;

    @NotNull
    @Pattern(regexp = "^\\+\\d{1,3}-\\d{9}$", message = "Invalid mobile number format.")
    private String mobile;

    @NotNull
    @Pattern(regexp = "^\\+\\d{1,3}-\\d{9}$", message = "Invalid phone number format.")
    private String phone;

    private AddressDTO address;
}
