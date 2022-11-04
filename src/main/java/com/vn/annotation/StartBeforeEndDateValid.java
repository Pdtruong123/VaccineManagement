package com.vn.annotation;

import com.vn.util.StartBeforeEndDateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StartBeforeEndDateValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface StartBeforeEndDateValid {
    String message() default "start date must be before end date";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
