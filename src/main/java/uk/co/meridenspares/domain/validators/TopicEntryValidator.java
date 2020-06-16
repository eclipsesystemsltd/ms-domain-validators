package uk.co.meridenspares.domain.validators;

import uk.co.meridenspares.domain.TopicEntry;
import uk.co.meridenspares.domain.validators.exception.ObjectValidationException;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.persistence.api.TopicEntryPersistenceService;

/**
 * Validates the internal consistency of a 'TopicEntry' domain model object.
 * @author user
 *
 */
public class TopicEntryValidator extends GenericValidator<TopicEntry, TopicEntryPersistenceService> {
	
	/**
	 * Constructor.
	 * @param persistenceService
	 */
	public TopicEntryValidator(final TopicEntryPersistenceService persistenceService) {
		super(persistenceService);
	}

	/**
	 * Validates a 'TopicEntry' object.
	 * @Param object
	 */
	@Override
	public void validate(final TopicEntry object) throws ObjectValidationException, PersistenceServiceException {
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

