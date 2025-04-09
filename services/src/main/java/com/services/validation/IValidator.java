package com.services.validation;

import com.model.model.Identifiable;

public interface IValidator<T extends Identifiable<?>> {
    void validateEntity(T entity);
}
