package uk.co.meridenspares.domain.validators;

import uk.co.meridenspares.domain.AppUser;
import uk.co.meridenspares.domain.validators.exception.ObjectValidationException;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.persistence.api.AppUserPersistenceService;

/**
 * Validates the internal consistency of a 'AppUser' domain model object.
 * @author user
 *
 */
public class AppUserValidator extends GenericValidator<AppUser, AppUserPersistenceService> {
	
	/**
	 * Constructor.
	 * @param persistenceService
	 */
	public AppUserValidator(final AppUserPersistenceService persistenceService) {
		super(persistenceService);
	}

	/**
	 * Validates a 'AppUser' object.
	 * @Param appUser
	 */
	@Override
	public void validate(final AppUser appUser) throws ObjectValidationException, PersistenceServiceException {
		ObjectValidationException ove = new ObjectValidationException();
		
		if (appUser == null) {
			ove.getValidationErrors().put("AppUser", "cannot be null");
			throw ove;
		}
		
		validateName(appUser, ove);
		
		if (ove.getValidationErrors().size() > 0) {
			throw ove;
		}
	}

	/**
	 * Validates 'AppUser' name, first for nullness and then for uniqueness.
	 * @Param appUser
	 * @Param ObjectValidationException
	 */
	public void validateName(final AppUser appUser, ObjectValidationException ove) throws PersistenceServiceException {
		if (appUser.getName() == null) {
			ove.getValidationErrors().put("name", "cannot be null");
		}
		else {
			int matchingNames = persistenceService.getCountByName(appUser.getName());
			
			if (matchingNames > 0) {
				ove.getValidationErrors().put("name", "must be unique");
			}
		}
	}
}

