package uk.co.meridenspares.domain.validators;

import uk.co.meridenspares.domain.TopicCommentAttachment;
import uk.co.meridenspares.domain.validators.exception.ObjectValidationException;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.persistence.api.TopicCommentAttachmentPersistenceService;

/**
 * Validates the internal consistency of a 'TopicCommentAttachment' domain model object.
 * @author user
 *
 */
public class TopicCommentAttachmentValidator extends GenericValidator<TopicCommentAttachment, TopicCommentAttachmentPersistenceService> {
	
	/**
	 * Constructor.
	 * @param persistenceService
	 */
	public TopicCommentAttachmentValidator(final TopicCommentAttachmentPersistenceService persistenceService) {
		super(persistenceService);
	}

	/**
	 * Validates a 'TopicCommentAttachment' object.
	 * @Param object
	 */
	@Override
	public void validate(final TopicCommentAttachment object) throws ObjectValidationException, PersistenceServiceException {
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

