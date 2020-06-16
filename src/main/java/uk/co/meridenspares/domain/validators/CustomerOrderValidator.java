package uk.co.meridenspares.domain.validators;

import uk.co.meridenspares.domain.CustomerOrder;
import uk.co.meridenspares.domain.validators.exception.ObjectValidationException;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.persistence.api.CustomerOrderPersistenceService;

/**
 * Validates the internal consistency of a 'CustomerOrder' domain model object.
 * @author user
 *
 */
public class CustomerOrderValidator extends GenericValidator<CustomerOrder, CustomerOrderPersistenceService> {
	
	/**
	 * Constructor.
	 * @param persistenceService
	 */
	public CustomerOrderValidator(final CustomerOrderPersistenceService persistenceService) {
		super(persistenceService);
	}

	/**
	 * Validates a 'CustomerOrder' object.
	 * @Param object
	 */
	@Override
	public void validate(final CustomerOrder object) throws ObjectValidationException, PersistenceServiceException {
		ObjectValidationException ove = new ObjectValidationException();
		
		if (object == null) {
			ove.getValidationErrors().put("object", "cannot be null");
			throw ove;
		}
		
		// Override and put extra checks here adding any errors to ObjectValidationException ...
		
		if (ove.getValidationErrors().size() > 0) {
			throw ove;
		}
	}
}

