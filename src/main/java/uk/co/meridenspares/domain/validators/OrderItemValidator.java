package uk.co.meridenspares.domain.validators;

import uk.co.meridenspares.domain.OrderItem;
import uk.co.meridenspares.domain.validators.exception.ObjectValidationException;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.persistence.api.OrderItemPersistenceService;

/**
 * Validates the internal consistency of a 'OrderItem' domain model object.
 * @author user
 *
 */
public class OrderItemValidator extends GenericValidator<OrderItem, OrderItemPersistenceService> {
	
	/**
	 * Constructor.
	 * @param persistenceService
	 */
	public OrderItemValidator(final OrderItemPersistenceService persistenceService) {
		super(persistenceService);
	}

	/**
	 * Validates a 'OrderItem' object.
	 * @Param object
	 */
	@Override
	public void validate(final OrderItem object) throws ObjectValidationException, PersistenceServiceException {
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

