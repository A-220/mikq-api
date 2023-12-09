package com.qst.mikq.annotations;

import com.qst.mikq.validators.DateOfDeadLineValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateOfDeadLineValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DateOfDeadLine {
    String message() default "Date of deadline cannot be before now date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}