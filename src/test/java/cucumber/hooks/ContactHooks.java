/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package cucumber.hooks;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.Before;
import salesforce.entities.Contact;
import static salesforce.api.petitions.ContactPetition.createContact;
import static salesforce.api.petitions.ContactPetition.deleteContact;

public class ContactHooks {
    private Contact contact;
    final String contactName = "Frank";
    final String contactLastName = "Castle";
    private static String contactId;

    public ContactHooks(final Contact newContact) {
        this.contact = newContact;
    }

    @Before(value = "@CreateContact")
    public void checkContactCreation() throws JsonProcessingException {
        if (contactId == null) {
            contact.setFirstName(contactName);
            contact.setLastName(contactLastName);
            contactId = createContact(contact);
        }
    }

    @Before(value = "not @CreateContact")
    public void checkAccountDeletion() {
        if (contactId != null) {
            deleteContact(contactId);
            contactId = null;
        }
    }

    /**
     * Gets the contact id.
     *
     * @return a String with the id
     */
    public static String getContactId() {
        return contactId;
    }
}
