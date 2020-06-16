package uk.co.meridenspares.domain.validators;

import uk.co.meridenspares.domain.TopicEntryAttachment;
import uk.co.meridenspares.domain.validators.exception.ObjectValidationException;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.persistence.api.TopicEntryAttachmentPersistenceService;

/**
 * Validates the internal consistency of a 'TopicEntryAttachment' domain model object.
 * @author user
 *
 */
public class TopicEntryAttachmentValidator extends GenericValidator<TopicEntryAttachment, TopicEntryAttachmentPersistenceService> {
	
	/**
	 * Constructor.
	 * @param persistenceService
	 */
	public TopicEntryAttachmentValidator(final TopicEntryAttachmentPersistenceService persistenceService) {
		super(persistenceService);
	}

	/**
	 * Validates a 'TopicEntryAttachment' object.
	 * @Param object
	 */
	@Override
	public void validate(final TopicEntryAttachment object) throws ObjectValidationException, PersistenceServiceException {
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

