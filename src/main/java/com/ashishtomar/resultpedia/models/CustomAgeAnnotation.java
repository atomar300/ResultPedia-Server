package com.ashishtomar.resultpedia.models;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CustomAgeValidator.class)
@Documented
public @interface CustomAgeAnnotation {
    String message() default "Age must be at least 10 years old";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
