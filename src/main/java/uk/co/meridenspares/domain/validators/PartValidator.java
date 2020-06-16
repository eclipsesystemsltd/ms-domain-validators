package uk.co.meridenspares.domain.validators;

import uk.co.meridenspares.domain.Part;
import uk.co.meridenspares.domain.validators.exception.ObjectValidationException;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.persistence.api.PartPersistenceService;

/**
 * Validates the internal consistency of a 'Part' domain model object.
 * @author user
 *
 */
public class PartValidator extends GenericValidator<Part, PartPersistenceService> {
	
	/**
	 * Constructor.
	 * @param persistenceService
	 */
	public PartValidator(final PartPersistenceService persistenceService) {
		super(persistenceService);
	}

	/**
	 * Validates a 'Part' object.
	 * @Param object
	 */
	@Override
	public void validate(final Part object) throws ObjectValidationException, PersistenceServiceException {
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

