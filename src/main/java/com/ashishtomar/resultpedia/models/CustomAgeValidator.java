package com.ashishtomar.resultpedia.models;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class CustomAgeValidator implements ConstraintValidator<CustomAgeAnnotation, LocalDate> {

    @Override
    public void initialize(CustomAgeAnnotation constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        LocalDate dateToCompare = LocalDate.now().minusYears(10);
        if (localDate.isBefore(dateToCompare)){
            return true;
        }
        return false;
    }
}
