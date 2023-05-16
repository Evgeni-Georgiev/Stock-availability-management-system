package eu.deltasource.training.retailchain.mapper;

import eu.deltasource.training.retailchain.dto.AddressDTO;
import eu.deltasource.training.retailchain.entity.Address;

import static eu.deltasource.training.retailchain.mapper.CountryMapper.*;

public class AddressMapper {

    /**
     * Convert AddressDTO to Address Entity.
     *
     * @param addressDTO DTO to convert from
     * @return converted entity
     */
    public static Address mapToAddress(AddressDTO addressDTO) {
        Address address = new Address();
        address.setAddressLine(addressDTO.getAddressLine());
        address.setCity(addressDTO.getCity());
        address.setPostalCode(addressDTO.getPostalCode());
        address.setCountry(mapToCountry(addressDTO.getCountry()));
        return address;
    }

    /**
     * Convert Address entity to AddressDTO.
     *
     * @param address entity to convert from
     * @return converted DTO
     */
    public static AddressDTO mapToAddressDTO(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setAddressLine(address.getAddressLine());
        addressDTO.setCity(address.getCity());
        addressDTO.setPostalCode(address.getPostalCode());
        addressDTO.setCountry(mapToCountryDTO(address.getCountry()));
        return addressDTO;
    }

    /**
     * Updates properties of an existing Address entity.
     *
     * @param addressDTO DTO to convert from.
     * @param address entity to convert to.
     */
    public static void updateAddressProperties(AddressDTO addressDTO, Address address) {
        address.setAddressLine(addressDTO.getAddressLine());
        address.setCity(addressDTO.getCity());
        address.setPostalCode(addressDTO.getPostalCode());
        updateCountryProperties(addressDTO.getCountry(), address.getCountry());
    }
}
