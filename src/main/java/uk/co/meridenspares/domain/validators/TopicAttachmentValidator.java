package uk.co.meridenspares.domain.validators;

import uk.co.meridenspares.domain.TopicAttachment;
import uk.co.meridenspares.domain.validators.exception.ObjectValidationException;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.persistence.api.TopicAttachmentPersistenceService;

/**
 * Validates the internal consistency of a 'TopicAttachment' domain model object.
 * @author user
 *
 */
public class TopicAttachmentValidator extends GenericValidator<TopicAttachment, TopicAttachmentPersistenceService> {
	
	/**
	 * Constructor.
	 * @param persistenceService
	 */
	public TopicAttachmentValidator(final TopicAttachmentPersistenceService persistenceService) {
		super(persistenceService);
	}

	/**
	 * Validates a 'TopicAttachment' object.
	 * @Param object
	 */
	@Override
	public void validate(final TopicAttachment object) throws ObjectValidationException, PersistenceServiceException {
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

