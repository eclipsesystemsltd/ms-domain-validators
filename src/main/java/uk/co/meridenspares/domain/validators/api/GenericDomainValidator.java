package uk.co.meridenspares.domain.validators.api;

import uk.co.meridenspares.domain.validators.exception.ObjectValidationException;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;

public interface GenericDomainValidator<T> {

	void validate(T object) throws ObjectValidationException, PersistenceServiceException;
}
