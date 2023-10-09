package eu.eugene.training.retailchain.mapper;

import eu.eugene.training.retailchain.dto.ContactDTO;
import eu.eugene.training.retailchain.entity.Contact;


/**
 * Provides static methods to map Contact and ContactDTO objects to each other.
 */
public class ContactMapper {

    /**
     * Maps ContactDTO object to Contact object.
     *
     * @param contactDTO Object to be mapped.
     * @return Mapped object.
     */
    public static Contact mapToContact(ContactDTO contactDTO) {
        Contact contact = new Contact();
        contact.setName(contactDTO.getName());
        contact.setEmail(contactDTO.getEmail());
        contact.setMobile(contactDTO.getMobile());
        contact.setPhone(contactDTO.getPhone());
        contact.setAddress(AddressMapper.mapToAddress(contactDTO.getAddress()));
        return contact;
    }

    /**
     * Maps Contact object to ContactDTO object.
     *
     * @param contact Object to be mapped.
     * @return Mapped object.
     */
    public static ContactDTO mapToContactDTO(Contact contact) {
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setName(contact.getName());
        contactDTO.setEmail(contact.getEmail());
        contactDTO.setMobile(contact.getMobile());
        contactDTO.setPhone(contact.getPhone());
        contactDTO.setAddress(AddressMapper.mapToAddressDTO(contact.getAddress()));
        return contactDTO;
    }

    /**
     * Maps the properties of ContactDTO object to Contact object.
     * The properties of an ContactDTO object will be mapped to an existing Contact object,
     * which will update the existing values.
     *
     * @param contactDTO ContactDTO object to be mapped.
     * @param contact Contact object to which the fields will be mapped.
     */
    public static void mapToContact(ContactDTO contactDTO, Contact contact) {
        contact.setName(contactDTO.getName());
        contact.setEmail(contactDTO.getEmail());
        contact.setMobile(contactDTO.getMobile());
        contact.setPhone(contactDTO.getPhone());
        AddressMapper.mapToAddress(contactDTO.getAddress(), contact.getAddress());
    }
}