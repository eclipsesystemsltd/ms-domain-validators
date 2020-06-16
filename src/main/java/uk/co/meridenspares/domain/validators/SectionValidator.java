package uk.co.meridenspares.domain.validators;

import uk.co.meridenspares.domain.Section;
import uk.co.meridenspares.domain.validators.exception.ObjectValidationException;
import uk.co.meridenspares.persistence.api.SectionPersistenceService;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;

/**
 * Validates the internal consistency of a 'Section' domain model object.
 * @author user
 *
 */
public class SectionValidator extends GenericValidator<Section, SectionPersistenceService> {
	
	/**
	 * Constructor.
	 * @param persistenceService
	 */
	public SectionValidator(final SectionPersistenceService persistenceService) {
		super(persistenceService);
	}

	/**
	 * Validates a 'Section' object.
	 * @Param object
	 */
	@Override
	public void validate(final Section object) throws ObjectValidationException, PersistenceServiceException {
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

