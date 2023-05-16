package eu.deltasource.training.retailchain.mapper;

import eu.deltasource.training.retailchain.dto.ContactDTO;
import eu.deltasource.training.retailchain.entity.Contact;

import static eu.deltasource.training.retailchain.mapper.AddressMapper.*;

public class ContactMapper {

    /**
     * Convert ContactDTO to Contact Entity.
     *
     * @param contactDTO DTO to convert from
     * @return converted entity
     */
    public static Contact mapToContact(ContactDTO contactDTO) {
        Contact contact = new Contact();
        contact.setName(contactDTO.getName());
        contact.setEmail(contactDTO.getEmail());
        contact.setMobile(contactDTO.getMobile());
        contact.setPhone(contactDTO.getPhone());
        contact.setAddress(mapToAddress(contactDTO.getAddress()));
        return contact;
    }

    /**
     * Convert Contact Entity to ContactDTO.
     *
     * @param contact entity to convert from
     * @return converted DTO
     */
    public static ContactDTO mapToContactDTO(Contact contact) {
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setName(contact.getName());
        contactDTO.setEmail(contact.getEmail());
        contactDTO.setMobile(contact.getMobile());
        contactDTO.setPhone(contact.getPhone());
        contactDTO.setAddress(mapToAddressDTO(contact.getAddress()));
        return contactDTO;
    }

    /**
     * Updates properties of an existing Contact entity.
     *
     * @param contactDTO DTO to convert from.
     * @param contact entity to convert to.
     */
    public static void updateContactProperties(ContactDTO contactDTO, Contact contact) {
        contact.setName(contactDTO.getName());
        contact.setEmail(contactDTO.getEmail());
        contact.setMobile(contactDTO.getMobile());
        contact.setPhone(contactDTO.getPhone());
        updateAddressProperties(contactDTO.getAddress(), contact.getAddress());
    }
}
