package com.trestman.api.petshop.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
public class EntityNotFoundException extends Exception {

    private Integer entityId;

    public EntityNotFoundException(Integer entityId, String message) {
        super(message);
        this.entityId = entityId;
    }

    public EntityNotFoundException(Integer entityId, String message, Throwable cause) {
        super(message, cause);
        this.entityId = entityId;
    }

    public EntityNotFoundException(Integer entityId, Throwable cause) {
        super(cause);
        this.entityId = entityId;
    }

    public EntityNotFoundException(
            Integer entityId,
            String message,
            Throwable cause,
            boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.entityId = entityId;
    }

}
