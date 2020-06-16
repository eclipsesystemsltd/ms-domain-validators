package uk.co.meridenspares.domain.validators;

import uk.co.meridenspares.domain.Model;
import uk.co.meridenspares.domain.validators.exception.ObjectValidationException;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.persistence.api.ModelPersistenceService;

/**
 * Validates the internal consistency of a 'Model' domain model object.
 * @author user
 *
 */
public class ModelValidator extends GenericValidator<Model, ModelPersistenceService> {
	
	/**
	 * Constructor.
	 * @param persistenceService
	 */
	public ModelValidator(final ModelPersistenceService persistenceService) {
		super(persistenceService);
	}

	/**
	 * Validates a 'Model' object.
	 * @Param object
	 */
	@Override
	public void validate(final Model object) throws ObjectValidationException, PersistenceServiceException {
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

