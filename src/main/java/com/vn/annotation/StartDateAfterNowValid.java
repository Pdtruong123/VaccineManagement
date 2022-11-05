package com.vn.annotation;

import com.vn.util.StartAfterNowValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StartAfterNowValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface StartDateAfterNowValid {
    String message() default "start date must be after now";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
