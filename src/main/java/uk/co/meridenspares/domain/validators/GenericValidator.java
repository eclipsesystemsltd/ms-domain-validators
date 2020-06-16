package uk.co.meridenspares.domain.validators;

import uk.co.meridenspares.domain.util.ValidationUtil;
import uk.co.meridenspares.domain.validators.api.GenericDomainValidator;
import uk.co.meridenspares.domain.validators.exception.ObjectValidationException;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;

public class GenericValidator<T, P> implements GenericDomainValidator<T> {

	protected P persistenceService;

	/**
	 * Constructor.
	 * @param persistenceService
	 */
	public GenericValidator(final P persistenceService) {
		ValidationUtil.nullCheck(persistenceService, "persistenceService");
		this.persistenceService = persistenceService;
	}

	/**
	 * Validates an object.
	 * @Param appUser
	 */
	public void validate(final T object) throws ObjectValidationException, PersistenceServiceException {
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
