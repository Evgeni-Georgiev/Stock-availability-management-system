package eu.deltasource.training.retailchain.mapper;

import eu.deltasource.training.retailchain.dto.CountryDTO;
import eu.deltasource.training.retailchain.entity.Country;

public class CountryMapper {

    /**
     * Convert CountryDTO to Country Entity.
     *
     * @param countryDTO DTO to convert from
     * @return converted entity
     */
    public static Country mapToCountry(CountryDTO countryDTO) {
        Country country = new Country();
        country.setName(countryDTO.getName());
        return country;
    }

    /**
     * Convert Country Entity to CountryDTO.
     *
     * @param country entity to convert from
     * @return converted DTO
     */
    public static CountryDTO mapToCountryDTO(Country country) {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setName(country.getName());
        return countryDTO;
    }

    /**
     * Updates properties of an existing Country entity.
     *
     * @param countryDTO DTO to convert from.
     * @param country    entity to convert to.
     */
    public static void updateCountryProperties(CountryDTO countryDTO, Country country) {
        country.setName(countryDTO.getName());
    }
}
