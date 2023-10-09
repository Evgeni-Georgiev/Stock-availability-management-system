package eu.deltasource.training.retailchain.mapper;

import eu.deltasource.training.retailchain.dto.AddressDTO;
import eu.deltasource.training.retailchain.entity.Address;

import static eu.deltasource.training.retailchain.mapper.CountryMapper.*;


/**
 * Provides static methods to map Address and AddressDTO objects to each other.
 */
public class AddressMapper {

    /**
     * Maps AddressDTO object to Address object.
     *
     * @param addressDTO Object to be mapped.
     * @return Address object containing the mapped information from the AddressDTO object.
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
     * Maps Address object to AddressDTO object.
     *
     * @param address Object to be mapped.
     * @return AddressDTO object containing the mapped information from the Address object.
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
     * Maps the properties of AddressDTO object to Address object.
     * The properties of an AddressDTO object will be mapped to an existing Address object,
     * which will update the existing values.
     *
     * @param addressDTO AddressDTO object to be mapped.
     * @param address Address object to which the fields will be mapped.
     */
    public static void mapToAddress(AddressDTO addressDTO, Address address) {
        address.setAddressLine(addressDTO.getAddressLine());
        address.setCity(addressDTO.getCity());
        address.setPostalCode(addressDTO.getPostalCode());
        mapToCountry(addressDTO.getCountry(), address.getCountry());
    }
}