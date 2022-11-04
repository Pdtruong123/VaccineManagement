package com.vn.util;

import com.vn.annotation.StartBeforeEndDateValid;
import com.vn.annotation.StartEndDateable;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class StartBeforeEndDateValidator implements ConstraintValidator<StartBeforeEndDateValid, StartEndDateable> {
    @Override
    public void initialize(StartBeforeEndDateValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(StartEndDateable bean, ConstraintValidatorContext context) {
        final LocalDate startDate = bean.getInjectionDate();
        final LocalDate endDate = bean.getNextInjectionDate();

        return endDate.isAfter(startDate);
    }
}
