package com.qst.mikq.validators;

import com.qst.mikq.annotations.DateOfDeadLine;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DateOfDeadLineValidator implements ConstraintValidator<DateOfDeadLine, LocalDate> {
    private static final LocalDate MIN_DEADLINE = LocalDate.now().plusDays(1L);

    @Override
    public boolean isValid(LocalDate releaseDate, ConstraintValidatorContext context) {
        return !releaseDate.isBefore(MIN_DEADLINE);
    }
}
