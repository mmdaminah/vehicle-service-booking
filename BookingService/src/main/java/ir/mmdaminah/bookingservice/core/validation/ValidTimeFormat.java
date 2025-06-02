package ir.mmdaminah.bookingservice.core.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = TimeFormatValidator.class)
@Target({ElementType.TYPE_USE, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidTimeFormat {

    String message() default "Invalid time format. Expected HH:MM";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
