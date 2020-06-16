package uk.co.meridenspares.domain.validators;

import uk.co.meridenspares.domain.TopicCategory;
import uk.co.meridenspares.domain.validators.exception.ObjectValidationException;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.persistence.api.TopicCategoryPersistenceService;

/**
 * Validates the internal consistency of a 'TopicCategory' domain model object.
 * @author user
 *
 */
public class TopicCategoryValidator extends GenericValidator<TopicCategory, TopicCategoryPersistenceService> {
	
	/**
	 * Constructor.
	 * @param persistenceService
	 */
	public TopicCategoryValidator(final TopicCategoryPersistenceService persistenceService) {
		super(persistenceService);
	}

	/**
	 * Validates a 'TopicCategory' object.
	 * @Param object
	 */
	@Override
	public void validate(final TopicCategory object) throws ObjectValidationException, PersistenceServiceException {
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

