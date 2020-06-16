package uk.co.meridenspares.domain.validators;

import uk.co.meridenspares.domain.Basket;
import uk.co.meridenspares.domain.validators.exception.ObjectValidationException;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.persistence.api.BasketPersistenceService;

/**
 * Validates the internal consistency of a 'Basket' domain model object.
 * @author user
 *
 */
public class BasketValidator extends GenericValidator<Basket, BasketPersistenceService> {
	
	/**
	 * Constructor.
	 * @param persistenceService
	 */
	public BasketValidator(final BasketPersistenceService persistenceService) {
		super(persistenceService);
	}

	/**
	 * Validates a 'Basket' object.
	 * @Param object
	 */
	@Override
	public void validate(final Basket object) throws ObjectValidationException, PersistenceServiceException {
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

