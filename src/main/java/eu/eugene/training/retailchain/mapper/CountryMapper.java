package eu.deltasource.training.retailchain.mapper;

import eu.deltasource.training.retailchain.dto.CountryDTO;
import eu.deltasource.training.retailchain.entity.Country;

/**
 * Provides static methods to map Country and CountryDTO objects to each other.
 */
public class CountryMapper {

    /**
     * Convert CountryDTO to Country Entity.
     *
     * @param countryDTO DTO to convert from.
     * @return Converted entity.
     */
    public static Country mapToCountry(CountryDTO countryDTO) {
        Country country = new Country();
        country.setName(countryDTO.getName());
        return country;
    }

    /**
     * Convert Country Entity to CountryDTO.
     *
     * @param country Entity to convert from.
     * @return Converted DTO.
     */
    public static CountryDTO mapToCountryDTO(Country country) {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setName(country.getName());
        return countryDTO;
    }

    /**
     * Maps the properties of CountryDTO object to Country object.
     * The properties of an CountryDTO object will be mapped to an existing Country object,
     * which will update the existing values.
     *
     * @param countryDTO CountryDTO object to be mapped.
     * @param country Country object to which the fields will be mapped.
     */
    public static void mapToCountry(CountryDTO countryDTO, Country country) {
        country.setName(countryDTO.getName());
    }
}
