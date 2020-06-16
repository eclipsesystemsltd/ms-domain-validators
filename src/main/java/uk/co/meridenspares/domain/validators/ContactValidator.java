package uk.co.meridenspares.domain.validators;

import uk.co.meridenspares.domain.Contact;
import uk.co.meridenspares.domain.validators.exception.ObjectValidationException;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.persistence.api.ContactPersistenceService;

/**
 * Validates the internal consistency of a 'Contact' domain model object.
 * @author user
 *
 */
public class ContactValidator extends GenericValidator<Contact, ContactPersistenceService> {
	
	/**
	 * Constructor.
	 * @param persistenceService
	 */
	public ContactValidator(final ContactPersistenceService persistenceService) {
		super(persistenceService);
	}

	/**
	 * Validates a 'Contact' object.
	 * @Param appUser
	 */
	@Override
	public void validate(final Contact contact) throws ObjectValidationException, PersistenceServiceException {
		ObjectValidationException ove = new ObjectValidationException();
		
		if (contact == null) {
			ove.getValidationErrors().put("Contact", "cannot be null");
			throw ove;
		}
		
		validateName(contact, ove);
		
		if (ove.getValidationErrors().size() > 0) {
			throw ove;
		}
	}

	/**
	 * Validates 'Contact' name, first for nullness and then for uniqueness.
	 * @Param contactUser
	 * @Param ObjectValidationException
	 */
	public void validateName(final Contact contactUser, ObjectValidationException ove) throws PersistenceServiceException {
		if (contactUser.getName() == null) {
			ove.getValidationErrors().put("name", "cannot be null");
		}
		else {
			int matchingNames = 0;////////////////////persistenceService.getCountByName(contactUser.getName());
			
			if (matchingNames > 0) {
				ove.getValidationErrors().put("name", "must be unique");
			}
		}
	}
}

