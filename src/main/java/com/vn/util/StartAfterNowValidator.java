package com.vn.util;

import com.vn.annotation.StartDateAfterNowValid;
import com.vn.annotation.StartEndDateable;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class StartAfterNowValidator implements ConstraintValidator<StartDateAfterNowValid, StartEndDateable> {
    @Override
    public void initialize(StartDateAfterNowValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(StartEndDateable bean, ConstraintValidatorContext context) {
        final LocalDate startDate = bean.getInjectionDate();
        return !LocalDate.now().isAfter(startDate);
    }
}
