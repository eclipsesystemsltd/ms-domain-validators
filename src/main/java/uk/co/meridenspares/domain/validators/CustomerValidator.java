package uk.co.meridenspares.domain.validators;

import uk.co.meridenspares.domain.Customer;
import uk.co.meridenspares.domain.validators.exception.ObjectValidationException;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.persistence.api.CustomerPersistenceService;

/**
 * Validates the internal consistency of a 'Customer' domain model object.
 * @author user
 *
 */
public class CustomerValidator extends GenericValidator<Customer, CustomerPersistenceService> {
	
	/**
	 * Constructor.
	 * @param persistenceService
	 */
	public CustomerValidator(final CustomerPersistenceService persistenceService) {
		super(persistenceService);
	}

	/**
	 * Validates a 'Customer' object.
	 * @Param appUser
	 */
	@Override
	public void validate(final Customer appUser) throws ObjectValidationException, PersistenceServiceException {
		ObjectValidationException ove = new ObjectValidationException();
		
		if (appUser == null) {
			ove.getValidationErrors().put("Customer", "cannot be null");
			throw ove;
		}
		
		validateName(appUser, ove);
		
		if (ove.getValidationErrors().size() > 0) {
			throw ove;
		}
	}

	/**
	 * Validates 'Customer' name, first for nullness and then for uniqueness.
	 * @Param appUser
	 * @Param ObjectValidationException
	 */
	public void validateName(final Customer customer, ObjectValidationException ove) throws PersistenceServiceException {
		if (customer.getLastName() == null) {
			ove.getValidationErrors().put("Last name", "cannot be null");
		}
	}
}

