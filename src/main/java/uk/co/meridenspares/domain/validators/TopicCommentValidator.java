package uk.co.meridenspares.domain.validators;

import uk.co.meridenspares.domain.TopicComment;
import uk.co.meridenspares.domain.validators.exception.ObjectValidationException;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.persistence.api.TopicCommentPersistenceService;

/**
 * Validates the internal consistency of a 'TopicComment' domain model object.
 * @author user
 *
 */
public class TopicCommentValidator extends GenericValidator<TopicComment, TopicCommentPersistenceService> {
	
	/**
	 * Constructor.
	 * @param persistenceService
	 */
	public TopicCommentValidator(final TopicCommentPersistenceService persistenceService) {
		super(persistenceService);
	}

	/**
	 * Validates a 'TopicComment' object.
	 * @Param object
	 */
	@Override
	public void validate(final TopicComment object) throws ObjectValidationException, PersistenceServiceException {
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

