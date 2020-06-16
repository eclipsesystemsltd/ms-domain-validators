package uk.co.meridenspares.domain.validators;

import uk.co.meridenspares.domain.Role;
import uk.co.meridenspares.domain.validators.exception.ObjectValidationException;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.persistence.api.RolePersistenceService;

/**
 * Validates the internal consistency of a 'Role' domain model object.
 * @author user
 *
 */
public class RoleValidator extends GenericValidator<Role, RolePersistenceService> {
	
	/**
	 * Constructor.
	 * @param persistenceService
	 */
	public RoleValidator(final RolePersistenceService persistenceService) {
		super(persistenceService);
	}

	/**
	 * Validates a 'Role' object.
	 * @Param object
	 */
	@Override
	public void validate(final Role object) throws ObjectValidationException, PersistenceServiceException {
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

